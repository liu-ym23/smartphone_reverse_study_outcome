package com.bytedance.android.live.soloktv;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.live.ktv.common.model.bean.f;
import com.bytedance.android.live.soloktv.model.k;
import com.bytedance.android.live.soloktv.model.n;
import com.bytedance.android.live.soloktv.record.SoloKtvRecordManager;
import com.bytedance.android.live.soloktv.util.j;
import com.bytedance.android.live.soloktv.view.SegmentSelectResult;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.mv.MvServiceImpl;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import fd2.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import nb1.i;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 ª\u00012\u00020\u0001:\u0002«\u0001B\t¢\u0006\u0006\b¨\u0001\u0010©\u0001J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR$\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR.\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u0010'\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER*\u0010F\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010\"\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&R\"\u0010J\u001a\u00020I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010Q\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010W\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010\"\u001a\u0004\bX\u0010$\"\u0004\bY\u0010&R$\u0010Z\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u001a\u001a\u0004\b[\u0010\u001c\"\u0004\b\\\u0010\u001eR!\u0010b\u001a\b\u0012\u0004\u0012\u00020^0]8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0012\u001a\u0004\b`\u0010aR$\u0010c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010j\u001a\u00020i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR!\u0010w\u001a\b\u0012\u0004\u0012\u00020I0]8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\u0012\u001a\u0004\bw\u0010aR!\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\u0012\u001a\u0004\by\u0010\u0014R!\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u0012\u001a\u0004\b|\u0010\u0014R\"\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\u0012\u001a\u0004\b\u007f\u0010\u0014R&\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020^0\u0081\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0082\u0001\u0010\u0012\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R,\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R(\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\"\u001a\u0005\b\u008e\u0001\u0010$\"\u0005\b\u008f\u0001\u0010&R%\u0010\u0093\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010]8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0091\u0001\u0010\u0012\u001a\u0005\b\u0092\u0001\u0010aR$\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\u0012\u001a\u0005\b\u0095\u0001\u0010\u0014R3\u0010\u0099\u0001\u001a\f\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010\u0097\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R&\u0010\u009f\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010\n\u001a\u0005\b \u0001\u0010\f\"\u0005\b¡\u0001\u0010\u000eR&\u0010¢\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u0010\n\u001a\u0005\b£\u0001\u0010\f\"\u0005\b¤\u0001\u0010\u000eR&\u0010¥\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¥\u0001\u0010\n\u001a\u0005\b¦\u0001\u0010\f\"\u0005\b§\u0001\u0010\u000e¨\u0006¬\u0001"}, d2 = {"Lcom/bytedance/android/live/soloktv/SoloKtvContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lfd2/p;", "initSerice", "", "calculateDuration", "Lcom/bytedance/android/live/soloktv/view/SegmentSelectResult;", "getSegment", "", "startLoadResourceTime", "J", "getStartLoadResourceTime", "()J", "setStartLoadResourceTime", "(J)V", "Lcom/bytedance/live/datacontext/m;", "", "singFlag$delegate", "Lcom/bytedance/live/datacontext/p;", "getSingFlag", "()Lcom/bytedance/live/datacontext/m;", "singFlag", "soloDuration", "getSoloDuration", "setSoloDuration", "lastCalTs", "Ljava/lang/Long;", "getLastCalTs", "()Ljava/lang/Long;", "setLastCalTs", "(Ljava/lang/Long;)V", "", "value", "pageIndicate", "Ljava/lang/String;", "getPageIndicate", "()Ljava/lang/String;", "setPageIndicate", "(Ljava/lang/String;)V", "lastPageIndicate", "getLastPageIndicate", "setLastPageIndicate", "Lcom/bytedance/android/live/soloktv/model/n;", "schemeExtraParams", "Lcom/bytedance/android/live/soloktv/model/n;", "getSchemeExtraParams", "()Lcom/bytedance/android/live/soloktv/model/n;", "setSchemeExtraParams", "(Lcom/bytedance/android/live/soloktv/model/n;)V", "Lcom/bytedance/android/live/soloktv/model/d;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/android/live/soloktv/model/d;", "getModel", "()Lcom/bytedance/android/live/soloktv/model/d;", "setModel", "(Lcom/bytedance/android/live/soloktv/model/d;)V", "Lcom/bytedance/android/live/soloktv/record/c;", "dataStore", "Lcom/bytedance/android/live/soloktv/record/c;", "getDataStore", "()Lcom/bytedance/android/live/soloktv/record/c;", "setDataStore", "(Lcom/bytedance/android/live/soloktv/record/c;)V", "Lcom/bytedance/android/live/soloktv/model/k;", "editDataStore", "Lcom/bytedance/android/live/soloktv/model/k;", "getEditDataStore", "()Lcom/bytedance/android/live/soloktv/model/k;", "setEditDataStore", "(Lcom/bytedance/android/live/soloktv/model/k;)V", "fromSource", "getFromSource", "setFromSource", "", "sourceInt", "I", "getSourceInt", "()I", "setSourceInt", "(I)V", "Lcom/bytedance/android/live/soloktv/record/SoloKtvRecordManager;", "soloKtvRecordManager", "Lcom/bytedance/android/live/soloktv/record/SoloKtvRecordManager;", "getSoloKtvRecordManager", "()Lcom/bytedance/android/live/soloktv/record/SoloKtvRecordManager;", "setSoloKtvRecordManager", "(Lcom/bytedance/android/live/soloktv/record/SoloKtvRecordManager;)V", "personalKaraokeMediaInfo", "getPersonalKaraokeMediaInfo", "setPersonalKaraokeMediaInfo", "currentSessionId", "getCurrentSessionId", "setCurrentSessionId", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "curMusicPanel$delegate", "getCurMusicPanel", "()Lcom/bytedance/live/datacontext/n;", "curMusicPanel", "mvService", "Lfd2/p;", "getMvService", "()Lfd2/p;", "setMvService", "(Lfd2/p;)V", "Lcom/bytedance/android/live/soloktv/music/download/a;", "musicDownloadService", "Lcom/bytedance/android/live/soloktv/music/download/a;", "getMusicDownloadService", "()Lcom/bytedance/android/live/soloktv/music/download/a;", "setMusicDownloadService", "(Lcom/bytedance/android/live/soloktv/music/download/a;)V", "shouldRemoveRecodingMiddlePage", "Z", "getShouldRemoveRecodingMiddlePage", "()Z", "setShouldRemoveRecodingMiddlePage", "(Z)V", "isInSoloKtvPage$delegate", "isInSoloKtvPage", "wiredHeadsetConnectState$delegate", "getWiredHeadsetConnectState", "wiredHeadsetConnectState", "wirelessHeadsetState$delegate", "getWirelessHeadsetState", "wirelessHeadsetState", "wiredHeadsetActiveState$delegate", "getWiredHeadsetActiveState", "wiredHeadsetActiveState", "Lcom/bytedance/live/datacontext/k;", "musicDataReady$delegate", "getMusicDataReady", "()Lcom/bytedance/live/datacontext/k;", "musicDataReady", "Lcom/bytedance/android/livesdk/message/model/od;", "currentSelectedMvInfo", "Lcom/bytedance/android/livesdk/message/model/od;", "getCurrentSelectedMvInfo", "()Lcom/bytedance/android/livesdk/message/model/od;", "setCurrentSelectedMvInfo", "(Lcom/bytedance/android/livesdk/message/model/od;)V", "preComposeVideoFile", "getPreComposeVideoFile", "setPreComposeVideoFile", "Lcom/bytedance/android/live/ktv/common/model/bean/f;", "musicDownloadResourceData$delegate", "getMusicDownloadResourceData", "musicDownloadResourceData", "hideBannerIfNeed$delegate", "getHideBannerIfNeed", "hideBannerIfNeed", "", "Lnb1/i;", "templateList", "Ljava/util/List;", "getTemplateList", "()Ljava/util/List;", "setTemplateList", "(Ljava/util/List;)V", "playDurationForLog", "getPlayDurationForLog", "setPlayDurationForLog", "startHomePageTimeMs", "getStartHomePageTimeMs", "setStartHomePageTimeMs", "startPrepareResTimeMs", "getStartPrepareResTimeMs", "setStartPrepareResTimeMs", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String SOLO_PAGE_ENTRANCE = "entrance";
    public static final String SOLO_PAGE_FIRST = "first";
    public static final String SOLO_PAGE_MIDDLE = "middle";
    public static final String SOLO_PAGE_PREEVIEW = "preview";
    public static final String SOLO_PAGE_RECORD = "record";
    private final p curMusicPanel$delegate;
    private od currentSelectedMvInfo;
    private Long currentSessionId;
    private com.bytedance.android.live.soloktv.record.c dataStore;
    private k editDataStore;
    private String fromSource;
    private final p hideBannerIfNeed$delegate;
    private final p isInSoloKtvPage$delegate;
    private Long lastCalTs;
    private String lastPageIndicate;
    private com.bytedance.android.live.soloktv.model.d model;
    private final p musicDataReady$delegate;
    private final p musicDownloadResourceData$delegate;
    private com.bytedance.android.live.soloktv.music.download.a musicDownloadService;
    private fd2.p mvService;
    private String pageIndicate;
    private String personalKaraokeMediaInfo;
    private long playDurationForLog;
    private String preComposeVideoFile;
    private n schemeExtraParams;
    private boolean shouldRemoveRecodingMiddlePage;
    private final p singFlag$delegate;
    private long soloDuration;
    private SoloKtvRecordManager soloKtvRecordManager;
    private int sourceInt;
    private long startHomePageTimeMs;
    private long startLoadResourceTime;
    private long startPrepareResTimeMs;
    private List<i> templateList;
    private final p wiredHeadsetActiveState$delegate;
    private final p wiredHeadsetConnectState$delegate;
    private final p wirelessHeadsetState$delegate;

    public static final class a {
        public a() {
        }

        public static SoloKtvContext a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(SoloKtvContext.class);
            if ((r100 instanceof SoloKtvContext) == true) goto L5;
            r100 = null;
        L5:
            SoloKtvContext r101 = (SoloKtvContext) r100;
            if (r101 == null) goto L8;
            return r101;
        L8:
            return new SoloKtvContext();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static f b() {
            com.bytedance.live.datacontext.n r100 = SoloKtvContext.access$getMusicDownloadResourceData$p(a());
            if (r100 != null) goto L7;
            return null;
        L7:
            return (f) r100.getValue();
        }

        public static void c(f r100) {
            com.bytedance.live.datacontext.n r101 = SoloKtvContext.access$getMusicDownloadResourceData$p(a());
            if (r101 == null) goto L6;
            r101.setValue(r100);
            return;
        }
    }

    private final com.bytedance.live.datacontext.n<f> getMusicDownloadResourceData() {
        return (com.bytedance.live.datacontext.n) this.musicDownloadResourceData$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.n<MusicPanel> getCurMusicPanel() {
        return (com.bytedance.live.datacontext.n) this.curMusicPanel$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> getHideBannerIfNeed() {
        return (m) this.hideBannerIfNeed$delegate.a(this, $$delegatedProperties[8]);
    }

    public final com.bytedance.live.datacontext.k<MusicPanel> getMusicDataReady() {
        return (com.bytedance.live.datacontext.k) this.musicDataReady$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Boolean> getSingFlag() {
        return (m) this.singFlag$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> getWiredHeadsetActiveState() {
        return (m) this.wiredHeadsetActiveState$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Boolean> getWiredHeadsetConnectState() {
        return (m) this.wiredHeadsetConnectState$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> getWirelessHeadsetState() {
        return (m) this.wirelessHeadsetState$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.n<Integer> isInSoloKtvPage() {
        return (com.bytedance.live.datacontext.n) this.isInSoloKtvPage$delegate.a(this, $$delegatedProperties[2]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(SoloKtvContext.class, "singFlag", "getSingFlag()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvContext.class, "curMusicPanel", "getCurMusicPanel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvContext.class, "isInSoloKtvPage", "isInSoloKtvPage()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvContext.class, "wiredHeadsetConnectState", "getWiredHeadsetConnectState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvContext.class, "wirelessHeadsetState", "getWirelessHeadsetState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvContext.class, "wiredHeadsetActiveState", "getWiredHeadsetActiveState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvContext.class, "musicDataReady", "getMusicDataReady()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvContext.class, "musicDownloadResourceData", "getMusicDownloadResourceData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(SoloKtvContext.class, "hideBannerIfNeed", "getHideBannerIfNeed()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final void calculateDuration() {
        Long r100 = this.lastCalTs;
        if (r100 == null) goto L5;
        this.soloDuration += System.currentTimeMillis() - r100.longValue();
        this.lastCalTs = null;
        return;
    L5:
        this.lastCalTs = Long.valueOf(System.currentTimeMillis());
    }

    public final SegmentSelectResult getSegment() {
        com.bytedance.android.live.soloktv.record.c r100 = this.dataStore;
        if (r100 == null) goto L9;
        k r101 = r100.f101453a;
        if (r101 == null) goto L9;
        eb1.f r102 = r101.b();
        if (r102 == null) goto L9;
        return r102.h();
    L9:
        return null;
    }

    public final fd2.p initSerice() {
        fd2.p r100 = this.mvService;
        if (r100 != null) goto L11;
        q r101 = ((IKtvService) jc1.k.n(IKtvService.class)).prepareMvService();
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.mv.n r102 = r101.a();
        if (r102 == null) goto L9;
        r102.f146084b = Long.valueOf(Integer.MAX_VALUE);
        r102.f146083a = 0L;
        j.f101607a.getClass();
        r102.c(j.d());
        MvServiceImpl r103 = r102.b();
        this.mvService = r103;
        return r103;
    L9:
        return null;
    L11:
        return r100;
    }

    public SoloKtvContext() {
        com.bytedance.live.datacontext.b.a(this, SoloKtvContext.class);
        cb1.a.C0422a.f22995a = this;
        Boolean r100 = Boolean.FALSE;
        this.singFlag$delegate = com.bytedance.live.datacontext.q.d(this, r100);
        this.pageIndicate = SOLO_PAGE_FIRST;
        this.lastPageIndicate = SOLO_PAGE_ENTRANCE;
        this.model = new com.bytedance.android.live.soloktv.model.i();
        this.fromSource = "";
        this.curMusicPanel$delegate = com.bytedance.live.datacontext.q.c(this);
        this.musicDownloadService = new com.bytedance.android.live.soloktv.music.download.a();
        this.shouldRemoveRecodingMiddlePage = true;
        this.isInSoloKtvPage$delegate = com.bytedance.live.datacontext.q.c(this);
        this.wiredHeadsetConnectState$delegate = com.bytedance.live.datacontext.q.d(this, r100);
        this.wirelessHeadsetState$delegate = com.bytedance.live.datacontext.q.d(this, r100);
        this.wiredHeadsetActiveState$delegate = com.bytedance.live.datacontext.q.d(this, r100);
        this.musicDataReady$delegate = com.bytedance.live.datacontext.e.b(this);
        this.musicDownloadResourceData$delegate = com.bytedance.live.datacontext.q.c(this);
        this.hideBannerIfNeed$delegate = com.bytedance.live.datacontext.q.d(this, r100);
    }

    public final od getCurrentSelectedMvInfo() {
        return this.currentSelectedMvInfo;
    }

    public final Long getCurrentSessionId() {
        return this.currentSessionId;
    }

    public final com.bytedance.android.live.soloktv.record.c getDataStore() {
        return this.dataStore;
    }

    public final k getEditDataStore() {
        return this.editDataStore;
    }

    public final String getFromSource() {
        return this.fromSource;
    }

    public final Long getLastCalTs() {
        return this.lastCalTs;
    }

    public final String getLastPageIndicate() {
        return this.lastPageIndicate;
    }

    public final com.bytedance.android.live.soloktv.model.d getModel() {
        return this.model;
    }

    public final com.bytedance.android.live.soloktv.music.download.a getMusicDownloadService() {
        return this.musicDownloadService;
    }

    public final fd2.p getMvService() {
        return this.mvService;
    }

    public final String getPageIndicate() {
        return this.pageIndicate;
    }

    public final String getPersonalKaraokeMediaInfo() {
        return this.personalKaraokeMediaInfo;
    }

    public final long getPlayDurationForLog() {
        return this.playDurationForLog;
    }

    public final String getPreComposeVideoFile() {
        return this.preComposeVideoFile;
    }

    public final n getSchemeExtraParams() {
        return this.schemeExtraParams;
    }

    public final boolean getShouldRemoveRecodingMiddlePage() {
        return this.shouldRemoveRecodingMiddlePage;
    }

    public final long getSoloDuration() {
        return this.soloDuration;
    }

    public final SoloKtvRecordManager getSoloKtvRecordManager() {
        return this.soloKtvRecordManager;
    }

    public final int getSourceInt() {
        return this.sourceInt;
    }

    public final long getStartHomePageTimeMs() {
        return this.startHomePageTimeMs;
    }

    public final long getStartLoadResourceTime() {
        return this.startLoadResourceTime;
    }

    public final long getStartPrepareResTimeMs() {
        return this.startPrepareResTimeMs;
    }

    public final List<i> getTemplateList() {
        return this.templateList;
    }

    public static final /* synthetic */ com.bytedance.live.datacontext.n access$getMusicDownloadResourceData$p(SoloKtvContext r100) {
        return r100.getMusicDownloadResourceData();
    }

    public final void setCurrentSelectedMvInfo(od r100) {
        this.currentSelectedMvInfo = r100;
    }

    public final void setCurrentSessionId(Long r100) {
        this.currentSessionId = r100;
    }

    public final void setDataStore(com.bytedance.android.live.soloktv.record.c r100) {
        this.dataStore = r100;
    }

    public final void setEditDataStore(k r100) {
        this.editDataStore = r100;
    }

    public final void setFromSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.fromSource = r100;
        switch(r100.hashCode()) {
            case -1018706016: goto L33;
            case -562830579: goto L30;
            case -539748537: goto L27;
            case 4212739: goto L24;
            case 109400031: goto L21;
            case 318756327: goto L18;
            case 457496782: goto L15;
            case 1013602427: goto L12;
            case 1015982800: goto L9;
            case 1862666772: goto L6;
            default: goto L35;
        };
    L35:
        this.sourceInt = 0;
        return;
    L6:
        if (r100.equals(NotificationCompat.CATEGORY_NAVIGATION) == false) goto L35;
        this.sourceInt = 7;
        return;
    L9:
        if (r100.equals("banner_ready") == false) goto L35;
    L13:
        this.sourceInt = 1;
        return;
    L12:
        if (r100.equals("banner_order") == false) goto L35;
    L15:
        if (r100.equals("search_music") == false) goto L35;
    L28:
        this.sourceInt = 3;
        return;
    L18:
        if (r100.equals("solo_ktv_detail_bottom") == false) goto L35;
        this.sourceInt = 6;
        return;
    L21:
        if (r100.equals("share") == false) goto L35;
        this.sourceInt = 8;
        return;
    L24:
        if (r100.equals("solo_ktv_detail") == false) goto L35;
        this.sourceInt = 5;
        return;
    L27:
        if (r100.equals("search_card") == false) goto L35;
    L30:
        if (r100.equals(com.bytedance.android.ec.core.event.a.VALUE_PERSONAL_HOMEPAGE) == false) goto L35;
        this.sourceInt = 2;
        return;
    L33:
        if (r100.equals("voice_ktv") == false) goto L35;
        this.sourceInt = 4;
    }

    public final void setLastCalTs(Long r100) {
        this.lastCalTs = r100;
    }

    public final void setLastPageIndicate(String r100) {
        if (Intrinsics.areEqual(r100, SOLO_PAGE_FIRST) == false) goto L5;
        this.lastPageIndicate = SOLO_PAGE_ENTRANCE;
        return;
    L5:
        this.lastPageIndicate = r100;
    }

    public final void setModel(com.bytedance.android.live.soloktv.model.d r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.model = r100;
    }

    public final void setMusicDownloadService(com.bytedance.android.live.soloktv.music.download.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.musicDownloadService = r100;
    }

    public final void setMvService(fd2.p r100) {
        this.mvService = r100;
    }

    public final void setPageIndicate(String r100) {
        setLastPageIndicate(this.pageIndicate);
        this.pageIndicate = r100;
    }

    public final void setPersonalKaraokeMediaInfo(String r100) {
        this.personalKaraokeMediaInfo = r100;
    }

    public final void setPlayDurationForLog(long r100) {
        this.playDurationForLog = r100;
    }

    public final void setPreComposeVideoFile(String r100) {
        this.preComposeVideoFile = r100;
    }

    public final void setSchemeExtraParams(n r100) {
        this.schemeExtraParams = r100;
    }

    public final void setShouldRemoveRecodingMiddlePage(boolean r100) {
        this.shouldRemoveRecodingMiddlePage = r100;
    }

    public final void setSoloDuration(long r100) {
        this.soloDuration = r100;
    }

    public final void setSoloKtvRecordManager(SoloKtvRecordManager r100) {
        this.soloKtvRecordManager = r100;
    }

    public final void setSourceInt(int r100) {
        this.sourceInt = r100;
    }

    public final void setStartHomePageTimeMs(long r100) {
        this.startHomePageTimeMs = r100;
    }

    public final void setStartLoadResourceTime(long r100) {
        this.startLoadResourceTime = r100;
    }

    public final void setStartPrepareResTimeMs(long r100) {
        this.startPrepareResTimeMs = r100;
    }

    public final void setTemplateList(List<i> r100) {
        this.templateList = r100;
    }
}
