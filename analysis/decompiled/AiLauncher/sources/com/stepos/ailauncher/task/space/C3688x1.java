package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import o6.C5009a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/task/space/x1;", "", "<init>", "()V", "", "tab", "scanSource", "scanType", "assetId", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/task/space/x1$a;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/task/space/x1$a;", "MMKV_ID", "Ljava/lang/String;", "KEY_PENDING_AUTO_OPEN_TAB", "KEY_PENDING_SCAN_SOURCE", "KEY_PENDING_SCAN_TYPE", "KEY_PENDING_ASSET_ID", "PENDING_DEFAULT_TAB", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.x1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3688x1 {
    public static final C3688x1 INSTANCE = new C3688x1();
    private static final String KEY_PENDING_ASSET_ID = "pending_asset_id";
    private static final String KEY_PENDING_AUTO_OPEN_TAB = "pending_auto_open_tab";
    private static final String KEY_PENDING_SCAN_SOURCE = "pending_scan_source";
    private static final String KEY_PENDING_SCAN_TYPE = "pending_scan_type";
    private static final String MMKV_ID = "test_space_entry";
    private static final String PENDING_DEFAULT_TAB = "default";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/task/space/x1$a;", "", "", "tab", "scanSource", "scanType", "assetId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.x1$a, reason: from toString */
    public static final /* data */ class PendingOpen {
        private final String assetId;
        private final String scanSource;
        private final String scanType;
        private final String tab;

        public PendingOpen(String str, String str2, String str3, String str4) {
            this.tab = str;
            this.scanSource = str2;
            this.scanType = str3;
            this.assetId = str4;
        }

        /* renamed from: a, reason: from getter */
        public final String getAssetId() {
            return this.assetId;
        }

        /* renamed from: b, reason: from getter */
        public final String getScanSource() {
            return this.scanSource;
        }

        /* renamed from: c, reason: from getter */
        public final String getScanType() {
            return this.scanType;
        }

        /* renamed from: d, reason: from getter */
        public final String getTab() {
            return this.tab;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingOpen)) {
                return false;
            }
            PendingOpen pendingOpen = (PendingOpen) other;
            return kotlin.jvm.internal.p.d(this.tab, pendingOpen.tab) && kotlin.jvm.internal.p.d(this.scanSource, pendingOpen.scanSource) && kotlin.jvm.internal.p.d(this.scanType, pendingOpen.scanType) && kotlin.jvm.internal.p.d(this.assetId, pendingOpen.assetId);
        }

        public int hashCode() {
            String str = this.tab;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.scanSource;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.scanType;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.assetId;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "PendingOpen(tab=" + this.tab + ", scanSource=" + this.scanSource + ", scanType=" + this.scanType + ", assetId=" + this.assetId + ")";
        }
    }

    public final PendingOpen a() {
        C5009a c5009a = C5009a.INSTANCE;
        String strU = c5009a.u(MMKV_ID, KEY_PENDING_AUTO_OPEN_TAB, "");
        if (strU.length() == 0) {
            return null;
        }
        c5009a.H(MMKV_ID, KEY_PENDING_AUTO_OPEN_TAB, "");
        String strU2 = c5009a.u(MMKV_ID, KEY_PENDING_SCAN_SOURCE, "");
        String strU3 = c5009a.u(MMKV_ID, KEY_PENDING_SCAN_TYPE, "");
        String strU4 = c5009a.u(MMKV_ID, KEY_PENDING_ASSET_ID, "");
        c5009a.H(MMKV_ID, KEY_PENDING_SCAN_SOURCE, "");
        c5009a.H(MMKV_ID, KEY_PENDING_SCAN_TYPE, "");
        c5009a.H(MMKV_ID, KEY_PENDING_ASSET_ID, "");
        if (kotlin.jvm.internal.p.d(strU, "default")) {
            strU = null;
        }
        if (strU2.length() == 0) {
            strU2 = null;
        }
        if (strU3.length() == 0) {
            strU3 = null;
        }
        return new PendingOpen(strU, strU2, strU3, strU4.length() != 0 ? strU4 : null);
    }

    public final void b(String tab, String scanSource, String scanType, String assetId) {
        C5009a c5009a = C5009a.INSTANCE;
        if (tab == null) {
            tab = "default";
        }
        c5009a.H(MMKV_ID, KEY_PENDING_AUTO_OPEN_TAB, tab);
        if (scanSource == null) {
            scanSource = "";
        }
        c5009a.H(MMKV_ID, KEY_PENDING_SCAN_SOURCE, scanSource);
        if (scanType == null) {
            scanType = "";
        }
        c5009a.H(MMKV_ID, KEY_PENDING_SCAN_TYPE, scanType);
        if (assetId == null) {
            assetId = "";
        }
        c5009a.H(MMKV_ID, KEY_PENDING_ASSET_ID, assetId);
    }
}
