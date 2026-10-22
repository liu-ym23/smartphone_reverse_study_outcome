package com.android.server.slice;

import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.scene.SceneUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes3.dex */
public class SliceProviderPermissions implements DirtyTracker, DirtyTracker.Persistable {
    private static final String ATTR_AUTHORITY = "authority";
    private static final String ATTR_PKG = "pkg";
    private static final String NAMESPACE = null;
    private static final String TAG = "SliceProviderPermissions";
    private static final String TAG_AUTHORITY = "authority";
    private static final String TAG_PKG = "pkg";
    static final String TAG_PROVIDER = "provider";
    private final ArrayMap<String, SliceAuthority> mAuths;
    private final SlicePermissionManager.PkgUser mPkg;
    private final DirtyTracker mTracker;

    public static class SliceAuthority implements DirtyTracker.Persistable {
        private final String mAuthority;
        private final ArraySet<SlicePermissionManager.PkgUser> mPkgs;
        private final DirtyTracker mTracker;

        /* JADX INFO: renamed from: -$$Nest$fgetmAuthority, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8167$$Nest$fgetmAuthority(SliceAuthority r0) {
            return r0.mAuthority;
        }

        public SliceAuthority(String authority, DirtyTracker tracker) {
            this.mPkgs = new ArraySet();
            this.mAuthority = authority;
            this.mTracker = tracker;
        }

        public String getAuthority() {
            return this.mAuthority;
        }

        public synchronized void addPkg(SlicePermissionManager.PkgUser pkg) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mPkgs.add(pkg) == false) goto L9;
            this.mTracker.onPersistableDirty(this);     // Catch: Throwable -> L7
        L9:
            monitor-exit(this);
        }

        public synchronized void removePkg(SlicePermissionManager.PkgUser pkg) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mPkgs.remove(pkg) == false) goto L9;
            this.mTracker.onPersistableDirty(this);     // Catch: Throwable -> L7
        L9:
            monitor-exit(this);
        }

        public synchronized Collection<SlicePermissionManager.PkgUser> getPkgs() {
            monitor-enter(this);
            ArraySet r0 = new ArraySet(this.mPkgs);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.slice.DirtyTracker.Persistable
        public String getFileName() {
            return null;
        }

        @Override // com.android.server.slice.DirtyTracker.Persistable
        public synchronized void writeTo(XmlSerializer out) throws IOException {
            monitor-enter(this);
            int N = this.mPkgs.size();     // Catch: Throwable -> L7
            int i = 0;
        L4:
            if (i >= N) goto L10;
            out.startTag(SliceProviderPermissions.m8166$$Nest$sfgetNAMESPACE(), SceneUtils.KEY_PKG);     // Catch: Throwable -> L7
            out.text(this.mPkgs.valueAt(i).toString());     // Catch: Throwable -> L7
            out.endTag(SliceProviderPermissions.m8166$$Nest$sfgetNAMESPACE(), SceneUtils.KEY_PKG);     // Catch: Throwable -> L7
            i = i + 1;
            goto L4
        L10:
            monitor-exit(this);
            return;
        L7:
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
            if (SceneUtils.KEY_PKG.equals(parser.getName()) == false) goto L13;
            this.mPkgs.add(new SlicePermissionManager.PkgUser(parser.nextText()));     // Catch: Throwable -> L11
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

        public boolean equals(Object obj) {
            Class<?> r0 = getClass();
            if (obj == null) goto L5;
            Class<?> r1 = obj.getClass();
        L7:
            if (r0.equals(r1) == true) goto L9;
            return false;
        L9:
            SliceAuthority other = (SliceAuthority) obj;
            if (Objects.equals(this.mAuthority, other.mAuthority) == true) goto L12;
            return false;
        L12:
            if (Objects.equals(this.mPkgs, other.mPkgs) == false) goto L17;
            return true;
        L17:
            return false;
        L5:
            r1 = null;
            goto L7
        }

        public String toString() {
            return String.format("(%s: %s)", new Object[]{this.mAuthority, this.mPkgs.toString()});
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetNAMESPACE, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8166$$Nest$sfgetNAMESPACE() {
        return NAMESPACE;
    }

    static {
        NAMESPACE = null;
    }

    public SliceProviderPermissions(SlicePermissionManager.PkgUser pkg, DirtyTracker tracker) {
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

    public synchronized SliceAuthority getOrCreateAuthority(String authority) {
        monitor-enter(this);
        SliceAuthority ret = this.mAuths.get(authority);     // Catch: Throwable -> L7
        if (ret != null) goto L9;
        ret = new SliceAuthority(authority, this);     // Catch: Throwable -> L7
        this.mAuths.put(authority, ret);     // Catch: Throwable -> L7
        onPersistableDirty(ret);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return ret;
    L7:
        th = move-exception;
        throw th;
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
        out.startTag(NAMESPACE, TAG_PROVIDER);     // Catch: Throwable -> L6
        out.attribute(NAMESPACE, SceneUtils.KEY_PKG, this.mPkg.toString());     // Catch: Throwable -> L6
        int N = this.mAuths.size();     // Catch: Throwable -> L6
        int i = 0;
    L4:
        if (i >= N) goto L8;
        out.startTag(NAMESPACE, "authority");     // Catch: Throwable -> L6
        out.attribute(NAMESPACE, "authority", SliceAuthority.m8167$$Nest$fgetmAuthority(this.mAuths.valueAt(i)));     // Catch: Throwable -> L6
        this.mAuths.valueAt(i).writeTo(out);     // Catch: Throwable -> L6
        out.endTag(NAMESPACE, "authority");     // Catch: Throwable -> L6
        i = i + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        out.endTag(NAMESPACE, TAG_PROVIDER);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static SliceProviderPermissions createFrom(XmlPullParser parser, DirtyTracker tracker) throws XmlPullParserException, IOException {
    L3:
        if (parser.getEventType() != 2) goto L20;
        if (TAG_PROVIDER.equals(parser.getName()) == false) goto L20;
        int depth = parser.getDepth();
        SlicePermissionManager.PkgUser pkgUser = new SlicePermissionManager.PkgUser(parser.getAttributeValue(NAMESPACE, SceneUtils.KEY_PKG));
        SliceProviderPermissions provider = new SliceProviderPermissions(pkgUser, tracker);
        parser.next();
    L9:
        if (parser.getDepth() <= depth) goto L19;
        if (parser.getEventType() != 2) goto L18;
        if ("authority".equals(parser.getName()) == false) goto L18;
        SliceAuthority authority = new SliceAuthority(parser.getAttributeValue(NAMESPACE, "authority"), provider);     // Catch: IllegalArgumentException -> L16
        authority.readFrom(parser);     // Catch: IllegalArgumentException -> L16
        provider.mAuths.put(authority.getAuthority(), authority);     // Catch: IllegalArgumentException -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, "Couldn't read PkgUser", e);
    L18:
        parser.next();
        goto L9
    L19:
        return provider;
    L20:
        parser.next();
        goto L3
    }

    public static String getFileName(SlicePermissionManager.PkgUser pkg) {
        return String.format("provider_%s", new Object[]{pkg.toString()});
    }
}
