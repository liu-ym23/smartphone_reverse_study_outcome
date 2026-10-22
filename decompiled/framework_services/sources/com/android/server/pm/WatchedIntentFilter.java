package com.android.server.pm;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.PatternMatcher;
import android.util.Printer;
import com.android.server.utils.Snappable;
import com.android.server.utils.WatchableImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class WatchedIntentFilter extends WatchableImpl implements Snappable<WatchedIntentFilter> {
    protected IntentFilter mFilter;

    private class WatchedIterator<E> implements Iterator<E> {
        private final Iterator<E> mIterator;
        final /* synthetic */ WatchedIntentFilter this$0;

        WatchedIterator(WatchedIntentFilter r1, Iterator<E> i) {
            this.this$0 = r1;
            this.mIterator = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.mIterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.mIterator.remove();
            WatchedIntentFilter.m7032$$Nest$monChanged(this.this$0);
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> action) {
            this.mIterator.forEachRemaining(action);
            WatchedIntentFilter.m7032$$Nest$monChanged(this.this$0);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$monChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7032$$Nest$monChanged(WatchedIntentFilter r0) {
        r0.onChanged();
    }

    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    private <E> Iterator<E> maybeWatch(Iterator<E> i) {
        if (i != null) goto L5;
        return i;
    L5:
        return new WatchedIterator(this, i);
    }

    private void onChanged() {
        dispatchChange(this);
    }

    protected WatchedIntentFilter() {
        this.mFilter = new IntentFilter();
    }

    public WatchedIntentFilter(IntentFilter f) {
        this.mFilter = new IntentFilter(f);
    }

    protected WatchedIntentFilter(WatchedIntentFilter f) {
        this(f.getIntentFilter());
    }

    public WatchedIntentFilter(String action) {
        this.mFilter = new IntentFilter(action);
    }

    public WatchedIntentFilter(String action, String dataType) throws IntentFilter.MalformedMimeTypeException {
        this.mFilter = new IntentFilter(action, dataType);
    }

    public WatchedIntentFilter cloneFilter() {
        return new WatchedIntentFilter(this.mFilter);
    }

    public IntentFilter getIntentFilter() {
        return this.mFilter;
    }

    public final void setPriority(int priority) {
        this.mFilter.setPriority(priority);
        onChanged();
    }

    public final int getPriority() {
        return this.mFilter.getPriority();
    }

    public final void setOrder(int order) {
        this.mFilter.setOrder(order);
        onChanged();
    }

    public final int getOrder() {
        return this.mFilter.getOrder();
    }

    public final boolean getAutoVerify() {
        return this.mFilter.getAutoVerify();
    }

    public final boolean handleAllWebDataURI() {
        return this.mFilter.handleAllWebDataURI();
    }

    public final boolean handlesWebUris(boolean onlyWebSchemes) {
        return this.mFilter.handlesWebUris(onlyWebSchemes);
    }

    public final boolean needsVerification() {
        return this.mFilter.needsVerification();
    }

    public void setVerified(boolean verified) {
        this.mFilter.setVerified(verified);
        onChanged();
    }

    public void setVisibilityToInstantApp(int visibility) {
        this.mFilter.setVisibilityToInstantApp(visibility);
        onChanged();
    }

    public int getVisibilityToInstantApp() {
        return this.mFilter.getVisibilityToInstantApp();
    }

    public boolean isVisibleToInstantApp() {
        return this.mFilter.isVisibleToInstantApp();
    }

    public boolean isExplicitlyVisibleToInstantApp() {
        return this.mFilter.isExplicitlyVisibleToInstantApp();
    }

    public boolean isImplicitlyVisibleToInstantApp() {
        return this.mFilter.isImplicitlyVisibleToInstantApp();
    }

    public final void addAction(String action) {
        this.mFilter.addAction(action);
        onChanged();
    }

    public final int countActions() {
        return this.mFilter.countActions();
    }

    public final String getAction(int index) {
        return this.mFilter.getAction(index);
    }

    public final boolean hasAction(String action) {
        return this.mFilter.hasAction(action);
    }

    public final boolean matchAction(String action) {
        return this.mFilter.matchAction(action);
    }

    public final Iterator<String> actionsIterator() {
        return maybeWatch(this.mFilter.actionsIterator());
    }

    public final void addDataType(String type) throws IntentFilter.MalformedMimeTypeException {
        this.mFilter.addDataType(type);
        onChanged();
    }

    public final void addDynamicDataType(String type) throws IntentFilter.MalformedMimeTypeException {
        this.mFilter.addDynamicDataType(type);
        onChanged();
    }

    public final void clearDynamicDataTypes() {
        this.mFilter.clearDynamicDataTypes();
        onChanged();
    }

    public int countStaticDataTypes() {
        return this.mFilter.countStaticDataTypes();
    }

    public final boolean hasDataType(String type) {
        return this.mFilter.hasDataType(type);
    }

    public final boolean hasExactDynamicDataType(String type) {
        return this.mFilter.hasExactDynamicDataType(type);
    }

    public final boolean hasExactStaticDataType(String type) {
        return this.mFilter.hasExactStaticDataType(type);
    }

    public final int countDataTypes() {
        return this.mFilter.countDataTypes();
    }

    public final String getDataType(int index) {
        return this.mFilter.getDataType(index);
    }

    public final Iterator<String> typesIterator() {
        return maybeWatch(this.mFilter.typesIterator());
    }

    public final List<String> dataTypes() {
        return this.mFilter.dataTypes();
    }

    public final void addMimeGroup(String name) {
        this.mFilter.addMimeGroup(name);
        onChanged();
    }

    public final boolean hasMimeGroup(String name) {
        return this.mFilter.hasMimeGroup(name);
    }

    public final String getMimeGroup(int index) {
        return this.mFilter.getMimeGroup(index);
    }

    public final int countMimeGroups() {
        return this.mFilter.countMimeGroups();
    }

    public final Iterator<String> mimeGroupsIterator() {
        return maybeWatch(this.mFilter.mimeGroupsIterator());
    }

    public final void addDataScheme(String scheme) {
        this.mFilter.addDataScheme(scheme);
        onChanged();
    }

    public final int countDataSchemes() {
        return this.mFilter.countDataSchemes();
    }

    public final String getDataScheme(int index) {
        return this.mFilter.getDataScheme(index);
    }

    public final boolean hasDataScheme(String scheme) {
        return this.mFilter.hasDataScheme(scheme);
    }

    public final Iterator<String> schemesIterator() {
        return maybeWatch(this.mFilter.schemesIterator());
    }

    public final void addDataSchemeSpecificPart(String ssp, int type) {
        this.mFilter.addDataSchemeSpecificPart(ssp, type);
        onChanged();
    }

    public final void addDataSchemeSpecificPart(PatternMatcher ssp) {
        this.mFilter.addDataSchemeSpecificPart(ssp);
        onChanged();
    }

    public final int countDataSchemeSpecificParts() {
        return this.mFilter.countDataSchemeSpecificParts();
    }

    public final PatternMatcher getDataSchemeSpecificPart(int index) {
        return this.mFilter.getDataSchemeSpecificPart(index);
    }

    public final boolean hasDataSchemeSpecificPart(String data) {
        return this.mFilter.hasDataSchemeSpecificPart(data);
    }

    public final Iterator<PatternMatcher> schemeSpecificPartsIterator() {
        return maybeWatch(this.mFilter.schemeSpecificPartsIterator());
    }

    public final void addDataAuthority(String host, String port) {
        this.mFilter.addDataAuthority(host, port);
        onChanged();
    }

    public final void addDataAuthority(IntentFilter.AuthorityEntry ent) {
        this.mFilter.addDataAuthority(ent);
        onChanged();
    }

    public final int countDataAuthorities() {
        return this.mFilter.countDataAuthorities();
    }

    public final IntentFilter.AuthorityEntry getDataAuthority(int index) {
        return this.mFilter.getDataAuthority(index);
    }

    public final boolean hasDataAuthority(Uri data) {
        return this.mFilter.hasDataAuthority(data);
    }

    public final Iterator<IntentFilter.AuthorityEntry> authoritiesIterator() {
        return maybeWatch(this.mFilter.authoritiesIterator());
    }

    public final void addDataPath(String path, int type) {
        this.mFilter.addDataPath(path, type);
        onChanged();
    }

    public final void addDataPath(PatternMatcher path) {
        this.mFilter.addDataPath(path);
        onChanged();
    }

    public final int countDataPaths() {
        return this.mFilter.countDataPaths();
    }

    public final PatternMatcher getDataPath(int index) {
        return this.mFilter.getDataPath(index);
    }

    public final boolean hasDataPath(String data) {
        return this.mFilter.hasDataPath(data);
    }

    public final Iterator<PatternMatcher> pathsIterator() {
        return maybeWatch(this.mFilter.pathsIterator());
    }

    public final int matchDataAuthority(Uri data) {
        return this.mFilter.matchDataAuthority(data);
    }

    public final int matchDataAuthority(Uri data, boolean wildcardSupported) {
        return this.mFilter.matchDataAuthority(data, wildcardSupported);
    }

    public final int matchData(String type, String scheme, Uri data) {
        return this.mFilter.matchData(type, scheme, data);
    }

    public final void addCategory(String category) {
        this.mFilter.addCategory(category);
    }

    public final int countCategories() {
        return this.mFilter.countCategories();
    }

    public final String getCategory(int index) {
        return this.mFilter.getCategory(index);
    }

    public final boolean hasCategory(String category) {
        return this.mFilter.hasCategory(category);
    }

    public final Iterator<String> categoriesIterator() {
        return maybeWatch(this.mFilter.categoriesIterator());
    }

    public final String matchCategories(Set<String> categories) {
        return this.mFilter.matchCategories(categories);
    }

    public final int match(ContentResolver resolver, Intent intent, boolean resolve, String logTag) {
        return this.mFilter.match(resolver, intent, resolve, logTag);
    }

    public final int match(String action, String type, String scheme, Uri data, Set<String> categories, String logTag) {
        return this.mFilter.match(action, type, scheme, data, categories, logTag);
    }

    public final int match(String action, String type, String scheme, Uri data, Set<String> categories, String logTag, boolean supportWildcards, Collection<String> ignoreActions) {
        return this.mFilter.match(action, type, scheme, data, categories, logTag, supportWildcards, ignoreActions);
    }

    public void dump(Printer du, String prefix) {
        this.mFilter.dump(du, prefix);
    }

    public final int describeContents() {
        return this.mFilter.describeContents();
    }

    public boolean debugCheck() {
        return this.mFilter.debugCheck();
    }

    public boolean checkDataPathAndSchemeSpecificParts() {
        return this.mFilter.checkDataPathAndSchemeSpecificParts();
    }

    public ArrayList<String> getHostsList() {
        return this.mFilter.getHostsList();
    }

    public String[] getHosts() {
        return this.mFilter.getHosts();
    }

    public static List<WatchedIntentFilter> toWatchedIntentFilterList(List<IntentFilter> inList) {
        ArrayList<WatchedIntentFilter> outList = new ArrayList();
        int i = 0;
    L4:
        if (i >= inList.size()) goto L7;
        outList.add(new WatchedIntentFilter(inList.get(i)));
        i = i + 1;
        goto L4
    L7:
        return outList;
    }

    public static List<IntentFilter> toIntentFilterList(List<WatchedIntentFilter> inList) {
        ArrayList<IntentFilter> outList = new ArrayList();
        int i = 0;
    L4:
        if (i >= inList.size()) goto L7;
        outList.add(inList.get(i).getIntentFilter());
        i = i + 1;
        goto L4
    L7:
        return outList;
    }

    public WatchedIntentFilter snapshot() {
        return new WatchedIntentFilter(this);
    }
}
