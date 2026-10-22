package com.bytedance.android.livesdk.preview;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;
import com.bytedance.android.livesdkapi.message.IPreviewMessageManager;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j1 implements IPreviewMessageManager, xlc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f156562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ylc.c> f156563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Set<OnWRDSDataUpdateListener>> f156564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vlc.d f156565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wlc.c f156566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ylc.e f156567f;

    public static final class a implements ylc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j1 f156568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f156569b;

        @Override // ylc.c
        public final void onClear() {
        }

        @Override // ylc.c
        public final void a(com.ss.ugc.live.sdk.message.wrsc.data.a r100) {
            Intrinsics.checkNotNullParameter(r100, "roomDataSync");
            Map<String, Set<OnWRDSDataUpdateListener>> r101 = this.f156568a.f156564c;
            HashMap r102 = (HashMap) r101;
            Set r103 = (Set) r102.get(this.f156569b);
            if (r103 == null) goto L11;
            Iterator r104 = r103.iterator();
        L6:
            if (r104.hasNext() == false) goto L15;
            OnWRDSDataUpdateListener r105 = (OnWRDSDataUpdateListener) r104.next();
            ylc.c r106 = r105.getDataSyncListener();
            if (r106 == null) goto L10;
            r106.a(r100);
        L10:
            r105.onWRDSDataUpdate(r100.f458186g, r100.f458184e);
            goto L6
        L15:
            return;
        }

        public a(j1 r100, String r101) {
            this.f156568a = r100;
            this.f156569b = r101;
        }
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager, wlc.c
    public final void release() {
        this.f156566e.release();
        this.f156565d.release();
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void releaseWRDS() {
        Iterator r100 = ((HashMap) this.f156563b).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ylc.c) ((Map.Entry) r100.next()).getValue()).onClear();
        goto L4
    L6:
        ((HashMap) this.f156563b).clear();
        Iterator r101 = ((HashMap) this.f156564c).entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((Set) ((Map.Entry) r101.next()).getValue()).clear();
        goto L8
    L10:
        ((HashMap) this.f156564c).clear();
        this.f156567f.h();
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void startMessage() {
        this.f156565d.startMessage();
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void stopMessage() {
        this.f156565d.r(true);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final vlc.d getInnerMessageManager() {
        return this.f156565d;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final wlc.c getInnerStreamMessageManager() {
        return this.f156566e;
    }

    @Override // xlc.a
    public final tlc.d l(String r100) {
        vlc.d r101 = this.f156565d;
        if ((r101 instanceof xlc.a) == true) goto L5;
        r101 = null;
    L5:
        xlc.a r102 = (xlc.a) r101;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.l(r100);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void removeMessageListener(vlc.l r100) {
        this.f156565d.removeMessageListener(r100);
    }

    @Override // xlc.a
    public final tlc.d u(int r100) {
        vlc.d r101 = this.f156565d;
        if ((r101 instanceof xlc.a) == true) goto L5;
        r101 = null;
    L5:
        xlc.a r102 = (xlc.a) r101;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.u(r100);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager, wlc.c
    public final void updateStreamDelay(long r100) {
        this.f156566e.updateStreamDelay(r100);
    }

    @Override // xlc.a
    public final tlc.d H(int r100, String r101) {
        vlc.d r102 = this.f156565d;
        if ((r102 instanceof xlc.a) == true) goto L5;
        r102 = null;
    L5:
        xlc.a r103 = (xlc.a) r102;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.H(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void addMessageListener(String r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        this.f156565d.addMessageListener(r100, r101);
    }

    @Override // xlc.a
    public final tlc.d e(String r100, String r101) {
        vlc.d r102 = this.f156565d;
        if ((r102 instanceof xlc.a) == true) goto L5;
        r102 = null;
    L5:
        xlc.a r103 = (xlc.a) r102;
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.e(r100, r101);
    }

    @Override // xlc.a
    public final void g(String r100, vlc.l r101) {
        vlc.d r102 = this.f156565d;
        if ((r102 instanceof xlc.a) == true) goto L5;
        r102 = null;
    L5:
        xlc.a r103 = (xlc.a) r102;
        if (r103 == null) goto L9;
        r103.g(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void removeMessageListener(String r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        this.f156565d.removeMessageListener(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void removeWRDSListener(IPreviewSyncDataType r100, OnWRDSDataUpdateListener r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        String r102 = r100.getSyncKey();
        if (((HashMap) this.f156564c).containsKey(r102) == false) goto L5;
    L6:
        Set r103 = (Set) ((HashMap) this.f156564c).get(r102);
        if (r103 == null) goto L9;
        r103.remove(r101);
    L9:
        Collection r104 = (Collection) ((HashMap) this.f156564c).get(r102);
        if (r104 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L22;
        ylc.c r106 = (ylc.c) ((HashMap) this.f156563b).get(r102);
        if (r106 == null) goto L23;
        this.f156567f.i(r106);
        ylc.c r107 = (ylc.c) ((HashMap) this.f156563b).remove(r102);
        return;
    L23:
        return;
    L22:
        return;
    L12:
        if (r104.isEmpty() == true) goto L15;
        r105 = false;
        goto L16
    L5:
        if (((HashMap) this.f156563b).containsKey(r102) == true) goto L6;
    }

    @Override // xlc.a
    public final void y(int r100, vlc.l r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.f156565d.addMessageListener(r100, r101);
        tlc.d r102 = H(r100, null);
        if (r102 == null) goto L8;
        r101.onMessage(r102);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager, wlc.c
    public final void addMessageListener(String r100, wlc.b r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f156566e.addMessageListener(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager, wlc.c
    public final void removeMessageListener(String r100, wlc.b r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f156566e.removeMessageListener(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void addMessageListener(int r100, vlc.l r101) {
        this.f156565d.addMessageListener(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void removeMessageListener(int r100, vlc.l r101) {
        this.f156565d.removeMessageListener(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager, wlc.c
    public final void addMessageListener(int r100, wlc.b r101) {
        this.f156566e.addMessageListener(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager, wlc.c
    public final void removeMessageListener(int r100, wlc.b r101) {
        this.f156566e.removeMessageListener(r100, r101);
    }

    public j1(vlc.d r100, emc.a r101, ylc.e r102) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        Intrinsics.checkNotNullParameter(r101, "messageStreamManager");
        Intrinsics.checkNotNullParameter(r102, "wrdsManager");
        this.f156565d = r100;
        this.f156566e = r101;
        this.f156567f = r102;
        this.f156562a = "PreviewMessageManager";
        this.f156563b = new HashMap();
        this.f156564c = new HashMap();
    }

    @Override // xlc.a
    public final void D(int r100, vlc.l r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.f156565d.addMessageListener(r100, r101);
        tlc.d r103 = H(r100, r102);
        if (r103 == null) goto L8;
        r101.onMessage(r103);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPreviewMessageManager
    public final void addWRDSListener(IPreviewSyncDataType r100, OnWRDSDataUpdateListener r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        String r103 = r100.getSyncKey();
        dc2.a.a(r103, r100.getDataClass());
        if (((HashMap) this.f156564c).containsKey(r103) == true) goto L5;
        ((HashMap) this.f156564c).put(r103, new CopyOnWriteArraySet());
    L5:
        Set r104 = (Set) ((HashMap) this.f156564c).get(r103);
        if (r104 == null) goto L8;
        r104.add(r101);
    L8:
        if (r102 == false) goto L28;
        ylc.e r105 = this.f156567f;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r103, "key");
        com.ss.ugc.live.sdk.message.wrsc.data.a r106 = r105.e(r103);
        String r107 = this.f156562a;
        StringBuilder r108 = new StringBuilder("wrds key: ");
        r108.append(r103);
        r108.append(" get dataSync, version: ");
        String r109 = null;
        if (r106 == null) goto L12;
        Long r110 = Long.valueOf(r106.f458180a);
    L13:
        r108.append(r110);
        r108.append(", bizLogId: ");
        if (r106 == null) goto L16;
        r109 = r106.f458182c;
    L16:
        r108.append(r109);
        ALogger.i(r107, r108.toString());
        if (r106 == null) goto L28;
        Set r111 = (Set) ((HashMap) this.f156564c).get(r103);
        if (r111 == null) goto L28;
        Iterator r112 = r111.iterator();
    L22:
        if (r112.hasNext() == false) goto L28;
        OnWRDSDataUpdateListener r113 = (OnWRDSDataUpdateListener) r112.next();
        ylc.c r114 = r113.getDataSyncListener();
        if (r114 == null) goto L26;
        r114.a(r106);
    L26:
        r113.onWRDSDataUpdate(r106.f458186g, r106.f458184e);
        goto L22
    L12:
        r110 = null;
    L28:
        if (((HashMap) this.f156563b).containsKey(r103) == true) goto L34;
        a r115 = new a(this, r103);
        this.f156567f.d(r103, r115);
        ((HashMap) this.f156563b).put(r103, r115);
        return;
    }

    @Override // xlc.a
    public final void i(String r100, vlc.l r101, String r102) {
        vlc.d r103 = this.f156565d;
        if ((r103 instanceof xlc.a) == true) goto L5;
        r103 = null;
    L5:
        xlc.a r104 = (xlc.a) r103;
        if (r104 == null) goto L9;
        r104.i(r100, r101, r102);
        return;
    }
}
