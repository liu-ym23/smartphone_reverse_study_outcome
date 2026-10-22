package com.android.server;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.FastImmutableArraySet;
import android.util.LogPrinter;
import android.util.MutableInt;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.FastPrintWriter;
import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.pm.Computer;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class IntentResolver<F, R> {
    private static final boolean DEBUG = false;
    private static final String TAG = "IntentResolver";
    private static final boolean localLOGV = false;
    private static final boolean localVerificationLOGV = false;
    private static final Comparator mResolvePrioritySorter = null;
    private final ArrayMap<String, F[]> mActionToFilter;
    private final ArrayMap<String, F[]> mBaseTypeToFilter;
    protected final ArraySet<F> mFilters;
    private final ArrayMap<String, F[]> mSchemeToFilter;
    private final ArrayMap<String, F[]> mTypeToFilter;
    private final ArrayMap<String, F[]> mTypedActionToFilter;
    private final ArrayMap<String, F[]> mWildTypeToFilter;

    private class IteratorWrapper implements Iterator<F> {
        private F mCur;
        private final Iterator<F> mI;
        final /* synthetic */ IntentResolver this$0;

        IteratorWrapper(IntentResolver r1, Iterator<F> it) {
            this.this$0 = r1;
            this.mI = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mI.hasNext();
        }

        @Override // java.util.Iterator
        public F next() {
            F r0 = this.mI.next();
            this.mCur = r0;
            return r0;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.mCur == null) goto L5;
            this.this$0.removeFilterInternal(this.mCur);
        L5:
            this.mI.remove();
        }
    }

    protected abstract IntentFilter getIntentFilter(F r1);

    protected abstract boolean isPackageForFilter(String r1, F r2);

    protected abstract F[] newArray(int r1);

    public IntentResolver() {
        this.mFilters = new ArraySet();
        this.mTypeToFilter = new ArrayMap();
        this.mBaseTypeToFilter = new ArrayMap();
        this.mWildTypeToFilter = new ArrayMap();
        this.mSchemeToFilter = new ArrayMap();
        this.mActionToFilter = new ArrayMap();
        this.mTypedActionToFilter = new ArrayMap();
    }

    public void addFilter(PackageDataSnapshot snapshot, F f) {
        IntentFilter intentFilter = getIntentFilter(f);
        this.mFilters.add(f);
        int numS = register_intent_filter(f, intentFilter.schemesIterator(), this.mSchemeToFilter, "      Scheme: ");
        int numT = register_mime_types(f, "      Type: ");
        if (numS != 0) goto L6;
        if (numT != 0) goto L6;
        register_intent_filter(f, intentFilter.actionsIterator(), this.mActionToFilter, "      Action: ");
    L6:
        if (numT == 0) goto L9;
        register_intent_filter(f, intentFilter.actionsIterator(), this.mTypedActionToFilter, "      TypedAction: ");
        return;
    }

    public static boolean intentMatchesFilter(IntentFilter filter, Intent intent, String resolvedType) {
        if ((intent.getFlags() & 8) == 0) goto L5;
        boolean debug = true;
    L7:
        if (debug == false) goto L9;
        Printer logPrinter = new LogPrinter(2, TAG, 3);
    L10:
        if (debug == false) goto L12;
        Slog.v(TAG, "Intent: " + intent);
        Slog.v(TAG, "Matching against filter: " + filter);
        filter.dump(logPrinter, "  ");
    L12:
        int match = filter.match(intent.getAction(), resolvedType, intent.getScheme(), intent.getData(), intent.getCategories(), TAG);
        if (match < 0) goto L17;
        if (debug == false) goto L16;
        Slog.v(TAG, "Filter matched!  match=0x" + Integer.toHexString(match));
    L16:
        return true;
    L17:
        if (debug == false) goto L25;
        switch(match) {
            case -4: goto L23;
            case -3: goto L22;
            case -2: goto L21;
            case -1: goto L20;
            default: goto L19;
        };
    L19:
        String reason = "unknown reason";
    L24:
        Slog.v(TAG, "Filter did not match: " + reason);
        goto L25
    L20:
        reason = DatabaseHelper.SoundModelContract.KEY_TYPE;
        goto L24
    L21:
        reason = "data";
        goto L24
    L22:
        reason = DomainVerificationPersistence.ATTR_ACTION;
        goto L24
    L23:
        reason = "category";
    L25:
        return false;
    L9:
        logPrinter = null;
        goto L10
    L5:
        debug = false;
        goto L7
    }

    private ArrayList<F> collectFilters(F[] array, IntentFilter matching) {
        ArrayList<F> res = null;
        if (array == null) goto L16;
        int i = 0;
    L6:
        if (i >= array.length) goto L16;
        F cur = array[i];
        if (cur == null) goto L16;
        if (IntentFilter.filterEquals(getIntentFilter(cur), matching) == false) goto L15;
        if (res != null) goto L14;
        res = new ArrayList();
    L14:
        res.add(cur);
    L15:
        i = i + 1;
    L16:
        return res;
    }

    public ArrayList<F> findFilters(IntentFilter matching) {
        if (matching.countDataSchemes() != 1) goto L7;
        return collectFilters(this.mSchemeToFilter.get(matching.getDataScheme(0)), matching);
    L7:
        if (matching.countDataTypes() == 0) goto L13;
        if (matching.countActions() != 1) goto L13;
        return collectFilters(this.mTypedActionToFilter.get(matching.getAction(0)), matching);
    L13:
        if (matching.countDataTypes() == 0) goto L15;
    L20:
        ArrayList<F> res = null;
        Iterator<F> r1 = this.mFilters.iterator();
    L22:
        if (r1.hasNext() == false) goto L29;
        F cur = r1.next();
        if (IntentFilter.filterEquals(getIntentFilter(cur), matching) == false) goto L22;
        if (res != null) goto L27;
        res = new ArrayList();
    L27:
        res.add(cur);
        goto L22
    L29:
        return res;
    L15:
        if (matching.countDataSchemes() != 0) goto L20;
        if (matching.countActions() != 1) goto L20;
        return collectFilters(this.mActionToFilter.get(matching.getAction(0)), matching);
    }

    public void removeFilter(F f) {
        removeFilterInternal(f);
        this.mFilters.remove(f);
    }

    protected void removeFilterInternal(F f) {
        IntentFilter intentFilter = getIntentFilter(f);
        int numS = unregister_intent_filter(f, intentFilter.schemesIterator(), this.mSchemeToFilter, "      Scheme: ");
        int numT = unregister_mime_types(f, "      Type: ");
        if (numS != 0) goto L6;
        if (numT != 0) goto L6;
        unregister_intent_filter(f, intentFilter.actionsIterator(), this.mActionToFilter, "      Action: ");
    L6:
        if (numT == 0) goto L9;
        unregister_intent_filter(f, intentFilter.actionsIterator(), this.mTypedActionToFilter, "      TypedAction: ");
        return;
    }

    boolean dumpMap(PrintWriter out, String titlePrefix, String title, String prefix, ArrayMap<String, F[]> map, String packageName, boolean printFilter, boolean collapseDuplicates) {
        String eprefix = prefix + "  ";
        String fprefix = prefix + "    ";
        ArrayMap<Object, MutableInt> found = new ArrayMap();
        int mapi = 0;
        Printer printer = null;
        boolean printedSomething = false;
        String title2 = title;
    L4:
        if (mapi >= map.size()) goto L59;
        F[] a = map.valueAt(mapi);
        int N = a.length;
        boolean printedHeader = false;
        String r2 = ":";
        if (collapseDuplicates == false) goto L33;
        if (printFilter == true) goto L33;
        found.clear();
        String title3 = title2;
        int index = 0;
    L9:
        if (index >= N) goto L24;
        F filter = a[index];
        if (filter == null) goto L24;
        if (packageName == null) goto L16;
        int i = index;
        F filter2 = filter;
        if (isPackageForFilter(packageName, filter2) == true) goto L17;
        boolean printedSomething2 = printedSomething;
        Printer printer2 = printer;
    L21:
        index = i + 1;
        printedSomething = printedSomething2;
        printer = printer2;
        a = a;
    L17:
        printedSomething2 = printedSomething;
        Object label = filterToLabel(filter2);
        int index2 = found.indexOfKey(label);
        printer2 = printer;
        if (index2 >= 0) goto L20;
        found.put(label, new MutableInt(1));
        goto L21
    L20:
        found.valueAt(index2).value++;
        goto L21
    L16:
        i = index;
        filter2 = filter;
    L24:
        int i2 = 0;
        String title4 = title3;
    L26:
        if (i2 >= found.size()) goto L32;
        if (title4 == null) goto L29;
        out.print(titlePrefix);
        out.println(title4);
        title4 = null;
    L29:
        if (printedHeader == true) goto L31;
        out.print(eprefix);
        out.print(map.keyAt(mapi));
        out.println(":");
        printedHeader = true;
    L31:
        printedSomething = true;
        dumpFilterLabel(out, fprefix, found.keyAt(i2), found.valueAt(i2).value);
        i2 = i2 + 1;
        goto L26
    L32:
        printer = printer;
    L57:
        title2 = title4;
        printedSomething = printedSomething;
        mapi = mapi + 1;
    L33:
        String title5 = title2;
        printedSomething = printedSomething;
        int i3 = 0;
        title4 = title5;
        printer = printer;
    L35:
        if (i3 >= N) goto L57;
        F filter3 = a[i3];
        if (filter3 == null) goto L57;
        if (packageName == null) goto L42;
        F filter4 = filter3;
        if (this.isPackageForFilter(packageName, filter4) == true) goto L43;
        r2 = r2;
    L54:
        i3 = i3 + 1;
        IntentResolver<F, R> this = this;
        map = map;
        r2 = r2;
    L43:
        if (title4 == null) goto L45;
        out.print(titlePrefix);
        out.println(title4);
        title4 = null;
    L45:
        if (printedHeader == true) goto L47;
        out.print(eprefix);
        out.print(map.keyAt(mapi));
        out.println(r2);
        printedHeader = true;
    L47:
        this.dumpFilter(out, fprefix, filter4);
        if (printFilter == false) goto L53;
        if (printer != null) goto L52;
        printer = new PrintWriterPrinter(out);
    L52:
        this.getIntentFilter(filter4).dump(printer, fprefix + "  ");
        printedSomething = true;
        goto L54
    L53:
        r2 = r2;
        printedSomething = true;
        goto L54
    L42:
        filter4 = filter3;
        goto L43
    L59:
        return printedSomething;
    }

    void writeProtoMap(ProtoOutputStream proto, long fieldId, ArrayMap<String, F[]> map) {
        int N = map.size();
        int mapi = 0;
    L3:
        if (mapi >= N) goto L12;
        long token = proto.start(fieldId);
        proto.write(1138166333441L, map.keyAt(mapi));
        F[] r4 = map.valueAt(mapi);
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L10;
        F f = r4[r6];
        if (f == null) goto L9;
        proto.write(2237677961218L, f.toString());
    L9:
        r6 = r6 + 1;
        goto L5
    L10:
        proto.end(token);
        mapi = mapi + 1;
        goto L3
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        writeProtoMap(proto, 2246267895809L, this.mTypeToFilter);
        writeProtoMap(proto, 2246267895810L, this.mBaseTypeToFilter);
        writeProtoMap(proto, 2246267895811L, this.mWildTypeToFilter);
        writeProtoMap(proto, 2246267895812L, this.mSchemeToFilter);
        writeProtoMap(proto, 2246267895813L, this.mActionToFilter);
        writeProtoMap(proto, 2246267895814L, this.mTypedActionToFilter);
        proto.end(token);
    }

    public boolean dump(PrintWriter out, String title, String prefix, String packageName, boolean printFilter, boolean collapseDuplicates) {
        String innerPrefix = prefix + "  ";
        String sepPrefix = "\n" + prefix;
        String curPrefix = title + "\n" + prefix;
        if (dumpMap(out, curPrefix, "Full MIME Types:", innerPrefix, this.mTypeToFilter, packageName, printFilter, collapseDuplicates) == false) goto L6;
        curPrefix = sepPrefix;
    L6:
        if (dumpMap(out, curPrefix, "Base MIME Types:", innerPrefix, this.mBaseTypeToFilter, packageName, printFilter, collapseDuplicates) == false) goto L9;
        curPrefix = sepPrefix;
    L9:
        if (dumpMap(out, curPrefix, "Wild MIME Types:", innerPrefix, this.mWildTypeToFilter, packageName, printFilter, collapseDuplicates) == false) goto L12;
        curPrefix = sepPrefix;
    L12:
        if (dumpMap(out, curPrefix, "Schemes:", innerPrefix, this.mSchemeToFilter, packageName, printFilter, collapseDuplicates) == false) goto L15;
        curPrefix = sepPrefix;
    L15:
        if (dumpMap(out, curPrefix, "Non-Data Actions:", innerPrefix, this.mActionToFilter, packageName, printFilter, collapseDuplicates) == false) goto L18;
        curPrefix = sepPrefix;
    L18:
        if (dumpMap(out, curPrefix, "MIME Typed Actions:", innerPrefix, this.mTypedActionToFilter, packageName, printFilter, collapseDuplicates) == false) goto L20;
        curPrefix = sepPrefix;
    L20:
        if (curPrefix != sepPrefix) goto L22;
        return true;
    L22:
        return false;
    }

    public Iterator<F> filterIterator() {
        return new IteratorWrapper(this, this.mFilters.iterator());
    }

    public Set<F> filterSet() {
        return Collections.unmodifiableSet(this.mFilters);
    }

    public List<R> queryIntentFromList(Computer computer, Intent intent, String resolvedType, boolean defaultOnly, ArrayList<F[]> listCut, int userId, long customFlags) {
        "android.intent.action.PROCESS_TEXT".equals(intent.getAction());
        ArrayList<R> resultList = new ArrayList();
        if ((intent.getFlags() & 8) == 0) goto L6;
        boolean r0 = true;
    L5:
        boolean debug = r0;
        FastImmutableArraySet<String> categories = getFastIntentCategories(intent);
        String scheme = intent.getScheme();
        int N = listCut.size();
        int i = 0;
    L8:
        if (i >= N) goto L10;
        buildResolveList(computer, intent, categories, debug, defaultOnly, resolvedType, scheme, listCut.get(i), resultList, userId, customFlags);
        i = i + 1;
        goto L8
    L10:
        filterResults(resultList);
        sortResults(resultList);
        return resultList;
    L6:
        r0 = false;
        goto L5
    }

    public List<R> queryIntent(PackageDataSnapshot snapshot, Intent intent, String resolvedType, boolean defaultOnly, int userId) {
        return queryIntent(snapshot, intent, resolvedType, defaultOnly, userId, 0);
    }

    protected final List<R> queryIntent(PackageDataSnapshot snapshot, Intent intent, String resolvedType, boolean defaultOnly, int userId, long customFlags) {
        "android.intent.action.PROCESS_TEXT".equals(intent.getAction());
        String scheme = intent.getScheme();
        ArrayList<R> finalList = new ArrayList();
        if ((intent.getFlags() & 8) == 0) goto L5;
        boolean debug = true;
    L7:
        if (debug == false) goto L9;
        StringBuilder r1 = new StringBuilder();
        r1.append("Resolving type=");
        r1.append(resolvedType);
        r1.append(" scheme=");
        r1.append(scheme);
        r1.append(" defaultOnly=");
        r1.append(defaultOnly);
        r1.append(" userId=");
        int r10 = userId;
        r1.append(r10);
        r1.append(" of ");
        r1.append(intent);
        Slog.v(TAG, r1.toString());
    L10:
        F[] secondTypeCut = null;
        F[] thirdTypeCut = null;
        if (resolvedType == null) goto L44;
        int slashpos = resolvedType.indexOf(47);
        if (slashpos <= 0) goto L43;
        String baseType = resolvedType.substring(0, slashpos);
        if (baseType.equals(SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER) == true) goto L38;
        boolean debug2 = debug;
        if (resolvedType.length() == (slashpos + 2)) goto L19;
    L28:
        F[] firstTypeCut = this.mTypeToFilter.get(resolvedType);
        if (debug2 == false) goto L31;
        Slog.v(TAG, "First type cut: " + Arrays.toString(firstTypeCut));
    L31:
        F[] secondTypeCut2 = this.mWildTypeToFilter.get(baseType);
        if (debug2 == true) goto L33;
    L27:
        secondTypeCut = secondTypeCut2;
        thirdTypeCut = this.mWildTypeToFilter.get(SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER);
        if (debug2 == false) goto L37;
        Slog.v(TAG, "Third type cut: " + Arrays.toString(thirdTypeCut));
    L37:
        F[] secondTypeCut3 = secondTypeCut;
        F[] thirdTypeCut2 = thirdTypeCut;
    L46:
        if (scheme == null) goto L51;
        F[] schemeCut = this.mSchemeToFilter.get(scheme);
        F[] schemeCut2 = schemeCut;
        if (debug2 == false) goto L50;
        Slog.v(TAG, "Scheme list: " + Arrays.toString(schemeCut2));
    L50:
        F[] schemeCut3 = schemeCut2;
    L52:
        if (resolvedType != null) goto L59;
        if (scheme != null) goto L59;
        if (intent.getAction() == null) goto L59;
        F[] firstTypeCut2 = this.mActionToFilter.get(intent.getAction());
        firstTypeCut = firstTypeCut2;
        if (debug2 == false) goto L59;
        Slog.v(TAG, "Action list: " + Arrays.toString(firstTypeCut));
    L59:
        F[] firstTypeCut3 = firstTypeCut;
        FastImmutableArraySet<String> categories = getFastIntentCategories(intent);
        Computer computer = (Computer) snapshot;
        if (firstTypeCut3 == null) goto L62;
        boolean debug3 = debug2;
        buildResolveList(computer, intent, categories, debug3, defaultOnly, resolvedType, scheme, firstTypeCut3, finalList, r10, customFlags);
    L63:
        if (secondTypeCut3 == null) goto L65;
        buildResolveList(computer, intent, categories, debug3, defaultOnly, resolvedType, scheme, secondTypeCut3, finalList, userId, customFlags);
    L65:
        if (thirdTypeCut2 == null) goto L67;
        buildResolveList(computer, intent, categories, debug3, defaultOnly, resolvedType, scheme, thirdTypeCut2, finalList, userId, customFlags);
    L67:
        if (schemeCut3 == null) goto L69;
        IntentResolver<F, R> r0 = this;
        r0.buildResolveList(computer, intent, categories, debug3, defaultOnly, resolvedType, scheme, schemeCut3, finalList, userId, customFlags);
    L70:
        r0.filterResults(finalList);
        r0.sortResults(finalList);
        if (debug3 == false) goto L76;
        Slog.v(TAG, "Final result list:");
        int i = 0;
    L74:
        if (i >= finalList.size()) goto L76;
        Slog.v(TAG, "  " + finalList.get(i));
        i = i + 1;
    L76:
        return finalList;
    L69:
        r0 = this;
        goto L70
    L62:
        debug3 = debug2;
        goto L63
    L51:
        schemeCut3 = null;
        goto L52
    L33:
        Slog.v(TAG, "Second type cut: " + Arrays.toString(secondTypeCut2));
        goto L27
    L19:
        if (resolvedType.charAt(slashpos + 1) != '*') goto L28;
        firstTypeCut = this.mBaseTypeToFilter.get(baseType);
        if (debug2 == false) goto L24;
        Slog.v(TAG, "First type cut: " + Arrays.toString(firstTypeCut));
    L24:
        secondTypeCut2 = this.mWildTypeToFilter.get(baseType);
        if (debug2 == false) goto L27;
        Slog.v(TAG, "Second type cut: " + Arrays.toString(secondTypeCut2));
        goto L27
    L38:
        debug2 = debug;
        if (intent.getAction() == null) goto L45;
        firstTypeCut = this.mTypedActionToFilter.get(intent.getAction());
        if (debug2 == false) goto L37;
        Slog.v(TAG, "Typed Action list: " + Arrays.toString(firstTypeCut));
    L45:
        secondTypeCut3 = null;
        thirdTypeCut2 = null;
        firstTypeCut = null;
        goto L46
    L43:
        debug2 = debug;
        goto L45
    L44:
        debug2 = debug;
        goto L45
    L9:
        r10 = userId;
        goto L10
    L5:
        debug = false;
        goto L7
    }

    protected boolean allowFilterResult(F filter, List<R> dest) {
        return true;
    }

    protected boolean isFilterStopped(Computer computer, F filter, int userId) {
        return false;
    }

    protected boolean isFilterVerified(F filter) {
        return getIntentFilter(filter).isVerified();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected R newResult(Computer computer, F r2, int match, int userId, long customFlags) {
        return r2;
    }

    protected void sortResults(List<R> results) {
        Collections.sort(results, mResolvePrioritySorter);
    }

    protected void filterResults(List<R> results) {
    }

    protected void dumpFilter(PrintWriter out, String prefix, F filter) {
        out.print(prefix);
        out.println(filter);
    }

    protected Object filterToLabel(F filter) {
        return "IntentFilter";
    }

    protected void dumpFilterLabel(PrintWriter out, String prefix, Object label, int count) {
        out.print(prefix);
        out.print(label);
        out.print(": ");
        out.println(count);
    }

    private final void addFilter(ArrayMap<String, F[]> map, String name, F filter) {
        F[] array = map.get(name);
        if (array != null) goto L5;
        F[] array2 = newArray(2);
        map.put(name, array2);
        array2[0] = filter;
        return;
    L5:
        int N = array.length;
        int i = N;
    L6:
        if (i <= 0) goto L10;
        if (array[i - 1] != null) goto L10;
        i = i - 1;
    L10:
        if (i >= N) goto L12;
        array[i] = filter;
        return;
    L12:
        F[] newa = newArray((N * 3) / 2);
        System.arraycopy(array, 0, newa, 0, N);
        newa[N] = filter;
        map.put(name, newa);
    }

    private final int register_mime_types(F filter, String prefix) {
        Iterator<String> i = getIntentFilter(filter).typesIterator();
        if (i != null) goto L5;
        return 0;
    L5:
        int num = 0;
    L7:
        if (i.hasNext() == false) goto L17;
        String name = i.next();
        num = num + 1;
        String baseName = name;
        int slashpos = name.indexOf(47);
        if (slashpos <= 0) goto L11;
        baseName = name.substring(0, slashpos).intern();
    L12:
        addFilter(this.mTypeToFilter, name, filter);
        if (slashpos > 0) goto L14;
        addFilter(this.mWildTypeToFilter, baseName, filter);
        goto L7
    L14:
        addFilter(this.mBaseTypeToFilter, baseName, filter);
        goto L7
    L11:
        name = name + "/*";
        goto L12
    L17:
        return num;
    }

    private final int unregister_mime_types(F filter, String prefix) {
        Iterator<String> i = getIntentFilter(filter).typesIterator();
        if (i != null) goto L5;
        return 0;
    L5:
        int num = 0;
    L7:
        if (i.hasNext() == false) goto L17;
        String name = i.next();
        num = num + 1;
        String baseName = name;
        int slashpos = name.indexOf(47);
        if (slashpos <= 0) goto L11;
        baseName = name.substring(0, slashpos).intern();
    L12:
        remove_all_objects(this.mTypeToFilter, name, filter);
        if (slashpos > 0) goto L14;
        remove_all_objects(this.mWildTypeToFilter, baseName, filter);
        goto L7
    L14:
        remove_all_objects(this.mBaseTypeToFilter, baseName, filter);
        goto L7
    L11:
        name = name + "/*";
        goto L12
    L17:
        return num;
    }

    protected final int register_intent_filter(F filter, Iterator<String> i, ArrayMap<String, F[]> dest, String prefix) {
        if (i != null) goto L5;
        return 0;
    L5:
        int num = 0;
    L7:
        if (i.hasNext() == false) goto L9;
        String name = i.next();
        num = num + 1;
        addFilter(dest, name, filter);
        goto L7
    L9:
        return num;
    }

    protected final int unregister_intent_filter(F filter, Iterator<String> i, ArrayMap<String, F[]> dest, String prefix) {
        if (i != null) goto L5;
        return 0;
    L5:
        int num = 0;
    L7:
        if (i.hasNext() == false) goto L9;
        String name = i.next();
        num = num + 1;
        remove_all_objects(dest, name, filter);
        goto L7
    L9:
        return num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void remove_all_objects(ArrayMap<String, F[]> r7, String name, F object) {
        F[] r0 = r7.get(name);
        if (r0 == null) goto L33;
        int LAST = r0.length - 1;
    L5:
        if (LAST < 0) goto L9;
        if (r0[LAST] != null) goto L9;
        LAST = LAST - 1;
    L9:
        int idx = LAST;
    L10:
        if (idx < 0) goto L21;
        Object r3 = r0[idx];
        if (r3 == null) goto L19;
        if (getIntentFilter(r3) != getIntentFilter(object)) goto L19;
        int remain = LAST - idx;
        if (remain <= 0) goto L18;
        System.arraycopy(r0, idx + 1, r0, idx, remain);
    L18:
        r0[LAST] = null;
        LAST = LAST - 1;
    L19:
        idx = idx - 1;
        goto L10
    L21:
        if (LAST >= 0) goto L24;
        r7.remove(name);
        return;
    L24:
        if (LAST >= (r0.length / 2)) goto L35;
        F[] r2 = newArray(LAST + 2);
        System.arraycopy(r0, 0, r2, 0, LAST + 1);
        r7.put(name, r2);
        return;
    L35:
        return;
    }

    private static FastImmutableArraySet<String> getFastIntentCategories(Intent intent) {
        Set<String> categories = intent.getCategories();
        if (categories != null) goto L7;
        return null;
    L7:
        return new FastImmutableArraySet((String[]) categories.toArray(new String[categories.size()]));
    }

    private void buildResolveList(Computer computer, Intent intent, FastImmutableArraySet<String> categories, boolean debug, boolean defaultOnly, String resolvedType, String scheme, F[] src, List<R> dest, int userId, long customFlags) {
        F[] r7 = src;
        String action = intent.getAction();
        Uri data = intent.getData();
        String packageName = intent.getPackage();
        boolean excludingStopped = intent.isExcludingStopped();
        String r2 = TAG;
        if (debug == false) goto L5;
        Printer logPrinter = new LogPrinter(2, TAG, 3);
        FastPrintWriter r4 = new FastPrintWriter(logPrinter);
    L6:
        if (r7 == null) goto L8;
        int N = r7.length;
    L9:
        boolean hasNonDefaults = false;
        int i = 0;
    L10:
        if (i >= N) goto L72;
        F filter = r7[i];
        if (filter == null) goto L72;
        if (debug == false) goto L15;
        Slog.v(r2, "Matching against filter " + filter);
    L15:
        if (excludingStopped == false) goto L21;
        FastPrintWriter r18 = r4;
        int r5 = userId;
        if (isFilterStopped(computer, filter, r5) == false) goto L22;
        if (debug == false) goto L20;
        Slog.v(r2, "  Filter's target is stopped; skipping");
        String packageName2 = packageName;
        Printer logPrinter2 = logPrinter;
        int N2 = N;
        FastPrintWriter r14 = r18;
        String r11 = r2;
        int i2 = i;
    L69:
        i = i2 + 1;
        r7 = src;
        r2 = r11;
        logPrinter = logPrinter2;
        r4 = r14;
        N = N2;
        packageName = packageName2;
        goto L10
    L20:
        packageName2 = packageName;
        logPrinter2 = logPrinter;
        N2 = N;
        r14 = r18;
        r11 = r2;
        i2 = i;
    L22:
        if (packageName != null) goto L24;
    L28:
        IntentFilter intentFilter = getIntentFilter(filter);
        if (intentFilter.getAutoVerify() == false) goto L36;
        if (debug == false) goto L35;
        Slog.v(r2, "  Filter verified: " + isFilterVerified(filter));
        int authorities = intentFilter.countDataAuthorities();
        int z = 0;
    L32:
        if (z >= authorities) goto L34;
        StringBuilder r15 = new StringBuilder();
        r15.append("   ");
        r15.append(intentFilter.getDataAuthority(z).getHost());
        Slog.v(r2, r15.toString());
        z = z + 1;
        packageName = packageName;
        goto L32
    L34:
        packageName2 = packageName;
    L38:
        if (allowFilterResult(filter, dest) == true) goto L42;
        if (debug == false) goto L41;
        Slog.v(r2, "  Filter's target already added");
        logPrinter2 = logPrinter;
        N2 = N;
        r14 = r18;
        r11 = r2;
        i2 = i;
        goto L69
    L41:
        logPrinter2 = logPrinter;
        N2 = N;
        r14 = r18;
        r11 = r2;
        i2 = i;
        goto L69
    L42:
        int match = intentFilter.match(action, resolvedType, scheme, data, categories, TAG);
        if (match >= 0) goto L45;
        r11 = r2;
        logPrinter2 = logPrinter;
        r14 = r18;
        N2 = N;
        i2 = i;
        if (debug == false) goto L69;
        switch(match) {
            case -4: goto L67;
            case -3: goto L66;
            case -2: goto L65;
            case -1: goto L64;
            default: goto L63;
        };
    L63:
        String reason = "unknown reason";
    L68:
        Slog.v(r11, "  Filter did not match: " + reason);
        goto L69
    L64:
        reason = DatabaseHelper.SoundModelContract.KEY_TYPE;
        goto L68
    L65:
        reason = "data";
        goto L68
    L66:
        reason = DomainVerificationPersistence.ATTR_ACTION;
        goto L68
    L67:
        reason = "category";
        goto L68
    L45:
        if (debug == false) goto L47;
        Slog.v(r2, "  Filter matched!  match=0x" + Integer.toHexString(match) + " hasDefault=" + intentFilter.hasCategory("android.intent.category.DEFAULT"));
    L47:
        if (defaultOnly == true) goto L49;
    L52:
        r11 = r2;
        logPrinter2 = logPrinter;
        r14 = r18;
        N2 = N;
        i2 = i;
        R oneResult = newResult(computer, filter, match, r5, customFlags);
        if (debug == false) goto L55;
        Slog.v(r11, "    Created result: " + oneResult);
    L55:
        if (oneResult == null) goto L69;
        dest.add(oneResult);
        if (debug == false) goto L69;
        dumpFilter(r14, "    ", filter);
        r14.flush();
        intentFilter.dump(logPrinter2, "    ");
        goto L69
    L49:
        if (intentFilter.hasCategory("android.intent.category.DEFAULT") == true) goto L52;
        logPrinter2 = logPrinter;
        N2 = N;
        hasNonDefaults = true;
        r14 = r18;
        r11 = r2;
        i2 = i;
        goto L69
    L35:
        packageName2 = packageName;
        goto L38
    L36:
        packageName2 = packageName;
        goto L38
    L24:
        if (isPackageForFilter(packageName, filter) == true) goto L28;
        if (debug == false) goto L27;
        Slog.v(r2, "  Filter is not from package " + packageName + "; skipping");
        packageName2 = packageName;
        logPrinter2 = logPrinter;
        N2 = N;
        r14 = r18;
        r11 = r2;
        i2 = i;
        goto L69
    L27:
        packageName2 = packageName;
        logPrinter2 = logPrinter;
        N2 = N;
        r14 = r18;
        r11 = r2;
        i2 = i;
        goto L69
    L21:
        r18 = r4;
        r5 = userId;
    L72:
        if (debug == false) goto L96;
        if (hasNonDefaults == true) goto L75;
        return;
    L75:
        if (dest.size() != 0) goto L78;
        Slog.v(r2, "resolveIntent failed: found match, but none with CATEGORY_DEFAULT");
        return;
    L78:
        if (dest.size() <= 1) goto L99;
        Slog.v(r2, "resolveIntent: multiple matches, only some with CATEGORY_DEFAULT");
        return;
    L99:
        return;
    L96:
        return;
    L8:
        N = 0;
        goto L9
    L5:
        logPrinter = null;
        r4 = null;
        goto L6
    }

    static {
        mResolvePrioritySorter = new AnonymousClass1();
    }

    protected F snapshot(F f) {
        return f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void copyInto(ArrayMap<String, F[]> r8, ArrayMap<String, F[]> r) {
        int end = r.size();
        r8.clear();
        r8.ensureCapacity(end);
        int i = 0;
    L3:
        if (i >= end) goto L10;
        F[] val = r.valueAt(i);
        String key = r.keyAt(i);
        Object[] r4 = Arrays.copyOf(val, val.length);
        int j = 0;
    L6:
        if (j >= r4.length) goto L8;
        r4[j] = snapshot(r4[j]);
        j = j + 1;
        goto L6
    L8:
        r8.put(key, r4);
        i = i + 1;
        goto L3
    }

    protected void copyInto(ArraySet<F> l, ArraySet<F> r) {
        l.clear();
        int end = r.size();
        l.ensureCapacity(end);
        int i = 0;
    L3:
        if (i >= end) goto L6;
        l.append(snapshot(r.valueAt(i)));
        i = i + 1;
        goto L3
    }

    protected void copyFrom(IntentResolver orig) {
        copyInto(this.mFilters, orig.mFilters);
        copyInto(this.mTypeToFilter, orig.mTypeToFilter);
        copyInto(this.mBaseTypeToFilter, orig.mBaseTypeToFilter);
        copyInto(this.mWildTypeToFilter, orig.mWildTypeToFilter);
        copyInto(this.mSchemeToFilter, orig.mSchemeToFilter);
        copyInto(this.mActionToFilter, orig.mActionToFilter);
        copyInto(this.mTypedActionToFilter, orig.mTypedActionToFilter);
    }
}
