package com.android.server.slice;

import android.net.Uri;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes3.dex */
public class SliceClientPermissions implements DirtyTracker, DirtyTracker.Persistable {
    private static final String ATTR_AUTHORITY = "authority";
    private static final String ATTR_FULL_ACCESS = "fullAccess";
    private static final String ATTR_PKG = "pkg";
    private static final String NAMESPACE = null;
    private static final String TAG = "SliceClientPermissions";
    private static final String TAG_AUTHORITY = "authority";
    static final String TAG_CLIENT = "client";
    private static final String TAG_PATH = "path";
    private final ArrayMap<SlicePermissionManager.PkgUser, SliceAuthority> mAuths;
    private boolean mHasFullAccess;
    private final SlicePermissionManager.PkgUser mPkg;
    private final DirtyTracker mTracker;

    public static class SliceAuthority implements DirtyTracker.Persistable {
        public static final String DELIMITER = "/";
        private final String mAuthority;
        private final ArraySet<String[]> mPaths;
        private final SlicePermissionManager.PkgUser mPkg;
        private final DirtyTracker mTracker;

        /* JADX INFO: renamed from: $r8$lambda$2-iHkkQ1bFl0JH28mlOkKy749k8, reason: not valid java name */
        public static /* synthetic */ String m8147$r8$lambda$2iHkkQ1bFl0JH28mlOkKy749k8(String[] r0) {
            return lambda$pathToString$2(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$A4KXJ-JvlDF8JfFpPT8MZLojIgA, reason: not valid java name */
        public static /* synthetic */ String m8148$r8$lambda$A4KXJJvlDF8JfFpPT8MZLojIgA(String[] r0) {
            return lambda$equals$1(r0);
        }

        public static /* synthetic */ String $r8$lambda$sU2JjYU2wieh0jw4EANPohjNDTI(String[] r0) {
            return lambda$equals$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAuthority, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8149$$Nest$fgetmAuthority(SliceAuthority r0) {
            return r0.mAuthority;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPkg, reason: not valid java name */
        static /* bridge */ /* synthetic */ SlicePermissionManager.PkgUser m8150$$Nest$fgetmPkg(SliceAuthority r0) {
            return r0.mPkg;
        }

        public SliceAuthority(String authority, SlicePermissionManager.PkgUser pkg, DirtyTracker tracker) {
            this.mPaths = new ArraySet();
            this.mAuthority = authority;
            this.mPkg = pkg;
            this.mTracker = tracker;
        }

        public String getAuthority() {
            return this.mAuthority;
        }

        public SlicePermissionManager.PkgUser getPkg() {
            return this.mPkg;
        }

        void addPath(List<String> path) {
            String[] pathSegs = (String[]) path.toArray(new String[path.size()]);
            int i = this.mPaths.size() - 1;
        L3:
            if (i < 0) goto L11;
            String[] existing = this.mPaths.valueAt(i);
            if (isPathPrefixMatch(existing, pathSegs) == true) goto L6;
            if (isPathPrefixMatch(pathSegs, existing) == false) goto L10;
            this.mPaths.removeAt(i);
        L10:
            i = i - 1;
            goto L3
        L6:
            return;
        L11:
            this.mPaths.add(pathSegs);
            this.mTracker.onPersistableDirty(this);
        }

        void removePath(List<String> path) {
            boolean changed = false;
            String[] pathSegs = (String[]) path.toArray(new String[path.size()]);
            int i = this.mPaths.size() - 1;
        L3:
            if (i < 0) goto L9;
            String[] existing = this.mPaths.valueAt(i);
            if (isPathPrefixMatch(pathSegs, existing) == false) goto L7;
            changed = true;
            this.mPaths.removeAt(i);
        L7:
            i = i - 1;
            goto L3
        L9:
            if (changed == false) goto L15;
            this.mTracker.onPersistableDirty(this);
            return;
        }

        public synchronized Collection<String[]> getPaths() {
            monitor-enter(this);
            ArraySet r0 = new ArraySet(this.mPaths);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public boolean hasPermission(List<String> path) {
            Iterator<String[]> r0 = this.mPaths.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            String[] p = r0.next();
            if (isPathPrefixMatch(p, (String[]) path.toArray(new String[path.size()])) == false) goto L4;
            return true;
        L10:
            return false;
        }

        private boolean isPathPrefixMatch(String[] prefix, String[] path) {
            int prefixSize = prefix.length;
            if (path.length >= prefixSize) goto L5;
            return false;
        L5:
            int i = 0;
        L6:
            if (i >= prefixSize) goto L11;
            if (Objects.equals(path[i], prefix[i]) == false) goto L9;
            i = i + 1;
            goto L6
        L9:
            return false;
        L11:
            return true;
        }

        @Override // com.android.server.slice.DirtyTracker.Persistable
        public String getFileName() {
            return null;
        }

        @Override // com.android.server.slice.DirtyTracker.Persistable
        public synchronized void writeTo(XmlSerializer out) throws IOException {
            monitor-enter(this);
            int N = this.mPaths.size();     // Catch: Throwable -> L9
            int i = 0;
        L4:
            if (i >= N) goto L13;
            String[] segments = this.mPaths.valueAt(i);     // Catch: Throwable -> L9
            if (segments == null) goto L11;
            out.startTag(SliceClientPermissions.m8146$$Nest$sfgetNAMESPACE(), SliceClientPermissions.TAG_PATH);     // Catch: Throwable -> L9
            out.text(encodeSegments(segments));     // Catch: Throwable -> L9
            out.endTag(SliceClientPermissions.m8146$$Nest$sfgetNAMESPACE(), SliceClientPermissions.TAG_PATH);     // Catch: Throwable -> L9
        L11:
            i = i + 1;
            goto L4
        L13:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public synchronized void readFrom(XmlPullParser parser) throws IOException, XmlPullParserException {
            monitor-enter(this);
            parser.next();     // Catch: Throwable -> L11
            int depth = parser.getDepth();     // Catch: Throwable -> L11
        L4:
            if (parser.getDepth() < depth) goto L15;
            if (parser.getEventType() != 2) goto L13;
            if (SliceClientPermissions.TAG_PATH.equals(parser.getName()) == false) goto L13;
            this.mPaths.add(decodeSegments(parser.nextText()));     // Catch: Throwable -> L11
        L13:
            parser.next();     // Catch: Throwable -> L11
            goto L4
        L15:
            monitor-exit(this);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private String encodeSegments(String[] s) {
            String[] out = new String[s.length];
            int i = 0;
        L4:
            if (i >= s.length) goto L7;
            out[i] = Uri.encode(s[i]);
            i = i + 1;
            goto L4
        L7:
            return TextUtils.join(DELIMITER, out);
        }

        private String[] decodeSegments(String s) {
            String[] sets = s.split(DELIMITER, -1);
            int i = 0;
        L4:
            if (i >= sets.length) goto L7;
            sets[i] = Uri.decode(sets[i]);
            i = i + 1;
            goto L4
        L7:
            return sets;
        }

        public boolean equals(Object obj) {
            Class<?> r0 = getClass();
            if (obj == null) goto L5;
            Class<?> r1 = obj.getClass();
        L7:
            if (r0.equals(r1) == true) goto L9;
            return false;
        L9:
            SliceAuthority other = (SliceAuthority) obj;
            if (this.mPaths.size() == other.mPaths.size()) goto L12;
            return false;
        L12:
            ArrayList<String[]> p1 = new ArrayList(this.mPaths);
            ArrayList<String[]> p2 = new ArrayList(other.mPaths);
            p1.sort(Comparator.comparing(new SliceClientPermissions$SliceAuthority$$ExternalSyntheticLambda0()));
            p2.sort(Comparator.comparing(new SliceClientPermissions$SliceAuthority$$ExternalSyntheticLambda1()));
            int i = 0;
        L14:
            if (i >= p1.size()) goto L27;
            String[] a1 = p1.get(i);
            String[] a2 = p2.get(i);
            if (a1.length != a2.length) goto L17;
            int j = 0;
        L20:
            if (j >= a1.length) goto L25;
            if (Objects.equals(a1[j], a2[j]) == false) goto L23;
            j = j + 1;
            goto L20
        L23:
            return false;
        L25:
            i = i + 1;
            goto L14
        L17:
            return false;
        L27:
            if (Objects.equals(this.mAuthority, other.mAuthority) == true) goto L29;
            return false;
        L29:
            if (Objects.equals(this.mPkg, other.mPkg) == false) goto L38;
            return true;
        L38:
            return false;
        L5:
            r1 = null;
            goto L7
        }

        private static /* synthetic */ String lambda$equals$0(String[] o) {
            return TextUtils.join(",", o);
        }

        private static /* synthetic */ String lambda$equals$1(String[] o) {
            return TextUtils.join(",", o);
        }

        public String toString() {
            return String.format("(%s, %s: %s)", new Object[]{this.mAuthority, this.mPkg.toString(), pathToString(this.mPaths)});
        }

        private static /* synthetic */ String lambda$pathToString$2(String[] s) {
            return TextUtils.join(DELIMITER, s);
        }

        private String pathToString(ArraySet<String[]> paths) {
            return TextUtils.join(", ", (Iterable) paths.stream().map(new SliceClientPermissions$SliceAuthority$$ExternalSyntheticLambda2()).collect(Collectors.toList()));
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetNAMESPACE, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8146$$Nest$sfgetNAMESPACE() {
        return NAMESPACE;
    }

    static {
        NAMESPACE = null;
    }

    public SliceClientPermissions(SlicePermissionManager.PkgUser pkg, DirtyTracker tracker) {
        this.mAuths = new ArrayMap();
        this.mPkg = pkg;
        this.mTracker = tracker;
    }

    public SlicePermissionManager.PkgUser getPkg() {
        return this.mPkg;
    }

    public synchronized Collection<SliceAuthority> getAuthorities() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(this.mAuths.values());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized SliceAuthority getOrCreateAuthority(SlicePermissionManager.PkgUser authority, SlicePermissionManager.PkgUser provider) {
        monitor-enter(this);
        SliceAuthority ret = this.mAuths.get(authority);     // Catch: Throwable -> L7
        if (ret != null) goto L9;
        ret = new SliceAuthority(authority.getPkg(), provider, this);     // Catch: Throwable -> L7
        this.mAuths.put(authority, ret);     // Catch: Throwable -> L7
        onPersistableDirty(ret);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return ret;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized SliceAuthority getAuthority(SlicePermissionManager.PkgUser authority) {
        monitor-enter(this);
        SliceAuthority r0 = this.mAuths.get(authority);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean hasFullAccess() {
        return this.mHasFullAccess;
    }

    public void setHasFullAccess(boolean hasFullAccess) {
        if (this.mHasFullAccess != hasFullAccess) goto L5;
        return;
    L5:
        this.mHasFullAccess = hasFullAccess;
        this.mTracker.onPersistableDirty(this);
    }

    public void removeAuthority(String authority, int userId) {
        if (this.mAuths.remove(new SlicePermissionManager.PkgUser(authority, userId)) == null) goto L6;
        this.mTracker.onPersistableDirty(this);
        return;
    }

    public synchronized boolean hasPermission(Uri uri, int userId) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (Objects.equals(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT, uri.getScheme()) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        SliceAuthority authority = getAuthority(new SlicePermissionManager.PkgUser(uri.getAuthority(), userId));     // Catch: Throwable -> L13
        if (authority == null) goto L15;
        if (authority.hasPermission(uri.getPathSegments()) == false) goto L15;
        r1 = true;
    L15:
        monitor-exit(this);
        return r1;
    }

    public void grantUri(Uri uri, SlicePermissionManager.PkgUser providerPkg) {
        SliceAuthority authority = getOrCreateAuthority(new SlicePermissionManager.PkgUser(uri.getAuthority(), providerPkg.getUserId()), providerPkg);
        authority.addPath(uri.getPathSegments());
    }

    public void revokeUri(Uri uri, SlicePermissionManager.PkgUser providerPkg) {
        SliceAuthority authority = getOrCreateAuthority(new SlicePermissionManager.PkgUser(uri.getAuthority(), providerPkg.getUserId()), providerPkg);
        authority.removePath(uri.getPathSegments());
    }

    public void clear() {
        if (this.mHasFullAccess == false) goto L5;
    L7:
        this.mHasFullAccess = false;
        this.mAuths.clear();
        onPersistableDirty(this);
        return;
    L5:
        if (this.mAuths.isEmpty() == false) goto L7;
    }

    @Override // com.android.server.slice.DirtyTracker
    public void onPersistableDirty(DirtyTracker.Persistable obj) {
        this.mTracker.onPersistableDirty(this);
    }

    @Override // com.android.server.slice.DirtyTracker.Persistable
    public String getFileName() {
        return getFileName(this.mPkg);
    }

    @Override // com.android.server.slice.DirtyTracker.Persistable
    public synchronized void writeTo(XmlSerializer out) throws IOException {
        monitor-enter(this);
        out.startTag(NAMESPACE, TAG_CLIENT);     // Catch: Throwable -> L6
        out.attribute(NAMESPACE, "pkg", this.mPkg.toString());     // Catch: Throwable -> L6
        String r0 = NAMESPACE;     // Catch: Throwable -> L6
        if (this.mHasFullAccess == false) goto L8;
        String r2 = "1";
    L9:
        out.attribute(r0, ATTR_FULL_ACCESS, r2);     // Catch: Throwable -> L6
        int N = this.mAuths.size();     // Catch: Throwable -> L6
        int i = 0;
    L10:
        if (i >= N) goto L12;
        out.startTag(NAMESPACE, "authority");     // Catch: Throwable -> L6
        out.attribute(NAMESPACE, "authority", SliceAuthority.m8149$$Nest$fgetmAuthority(this.mAuths.valueAt(i)));     // Catch: Throwable -> L6
        out.attribute(NAMESPACE, "pkg", SliceAuthority.m8150$$Nest$fgetmPkg(this.mAuths.valueAt(i)).toString());     // Catch: Throwable -> L6
        this.mAuths.valueAt(i).writeTo(out);     // Catch: Throwable -> L6
        out.endTag(NAMESPACE, "authority");     // Catch: Throwable -> L6
        i = i + 1;     // Catch: Throwable -> L6
        goto L10
    L12:
        out.endTag(NAMESPACE, TAG_CLIENT);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r2 = "0";
    L6:
        th = move-exception;
        throw th;
    }

    public static SliceClientPermissions createFrom(XmlPullParser parser, DirtyTracker tracker) throws XmlPullParserException, IOException {
    L3:
        if (parser.getEventType() == 2) goto L5;
    L30:
        int depth = parser.getEventType();
        if (depth == 1) goto L34;
        parser.next();
        goto L3
    L34:
        throw new XmlPullParserException("Can't find client tag in xml");
    L5:
        if (TAG_CLIENT.equals(parser.getName()) == false) goto L30;
        int depth2 = parser.getDepth();
        SlicePermissionManager.PkgUser pkgUser = new SlicePermissionManager.PkgUser(parser.getAttributeValue(NAMESPACE, "pkg"));
        SliceClientPermissions provider = new SliceClientPermissions(pkgUser, tracker);
        String fullAccess = parser.getAttributeValue(NAMESPACE, ATTR_FULL_ACCESS);
        if (fullAccess != null) goto L11;
        fullAccess = "0";
    L11:
        if (Integer.parseInt(fullAccess) == 0) goto L13;
        boolean r7 = true;
    L14:
        provider.mHasFullAccess = r7;
        parser.next();
    L16:
        if (parser.getDepth() <= depth2) goto L29;
        if (parser.getEventType() == 1) goto L19;
        if (parser.getEventType() != 2) goto L28;
        if ("authority".equals(parser.getName()) == false) goto L28;
        SlicePermissionManager.PkgUser pkg = new SlicePermissionManager.PkgUser(parser.getAttributeValue(NAMESPACE, "pkg"));     // Catch: IllegalArgumentException -> L26
        SliceAuthority authority = new SliceAuthority(parser.getAttributeValue(NAMESPACE, "authority"), pkg, provider);     // Catch: IllegalArgumentException -> L26
        authority.readFrom(parser);     // Catch: IllegalArgumentException -> L26
        provider.mAuths.put(new SlicePermissionManager.PkgUser(authority.getAuthority(), pkg.getUserId()), authority);     // Catch: IllegalArgumentException -> L26
    L26:
        e = move-exception;
        Slog.e(TAG, "Couldn't read PkgUser", e);
    L28:
        parser.next();
        goto L16
    L19:
        return provider;
    L29:
        return provider;
    L13:
        r7 = false;
        goto L14
    }

    public static String getFileName(SlicePermissionManager.PkgUser pkg) {
        return String.format("client_%s", new Object[]{pkg.toString()});
    }
}
