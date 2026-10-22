package com.bytedance.android.btm.impl.page.model;

import android.os.SystemClock;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.ShowIdUpdateReason;
import com.bytedance.android.btm.impl.chain.BtmChainRecorder;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BufferQueue;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.unknown.UnionBufferBtm;
import com.bytedance.android.btm.impl.page.unknown.UnionData;
import com.bytedance.android.btm.impl.pageshow.PageShowLog;
import com.bytedance.android.btm.impl.pageshow.checker.DuplicatedEnterPageChecker;
import com.bytedance.android.btm.impl.pageshow.checker.DuplicatedEnterPageChecker$monitor$$inlined$monitor$btm_impl_cnRelease$2;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b1\b\u0016\u0018\u0000 £\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001FB\t¢\u0006\u0006\b¢\u0001\u0010\u0097\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ4\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0013J\u001c\u0010!\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0013J\b\u0010$\u001a\u00020\u0000H\u0016J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0000J\u0006\u0010&\u001a\u00020\u0006J\u0006\u0010'\u001a\u00020\u0006J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004H\u0016R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b0\u0010-R\u0014\u00101\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b1\u0010-R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b2\u0010-R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u0010-R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010-\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010-\u001a\u0004\b@\u00106\"\u0004\bA\u00108R\"\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010-\u001a\u0004\bC\u00106\"\u0004\bD\u00108R$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010P\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010-\u001a\u0004\bN\u00106\"\u0004\bO\u00108R$\u0010T\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010-\u001a\u0004\bR\u00106\"\u0004\bS\u00108R$\u0010X\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010G\u001a\u0004\bV\u0010I\"\u0004\bW\u0010KR$\u0010\\\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010G\u001a\u0004\bZ\u0010I\"\u0004\b[\u0010KR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010-\u001a\u0004\b]\u00106\"\u0004\b^\u00108R\"\u0010_\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010:\u001a\u0004\b`\u0010<\"\u0004\ba\u0010>R\"\u0010\u0015\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010:\u001a\u0004\bb\u0010<\"\u0004\bc\u0010>R\"\u0010d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010:\u001a\u0004\be\u0010<\"\u0004\bf\u0010>R$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010t\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010z\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010u\u001a\u0004\b{\u0010w\"\u0004\b|\u0010yR\"\u0010}\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010u\u001a\u0004\b~\u0010w\"\u0004\b\u007f\u0010yR&\u0010\u0080\u0001\u001a\u00020s8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010u\u001a\u0005\b\u0081\u0001\u0010w\"\u0005\b\u0082\u0001\u0010yR+\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R(\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0089\u0001\u0010-\u001a\u0005\b\u008a\u0001\u00106\"\u0005\b\u008b\u0001\u00108R&\u0010\u008c\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010-\u001a\u0005\b\u008d\u0001\u00106\"\u0005\b\u008e\u0001\u00108R&\u0010\u008f\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010:\u001a\u0005\b\u008f\u0001\u0010<\"\u0005\b\u0090\u0001\u0010>R&\u0010\u0091\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010:\u001a\u0005\b\u0091\u0001\u0010<\"\u0005\b\u0092\u0001\u0010>R.\u0010\u0093\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u001d\n\u0005\b\u0093\u0001\u0010:\u0012\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0005\b\u0094\u0001\u0010<\"\u0005\b\u0095\u0001\u0010>R&\u0010\u0098\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010:\u001a\u0005\b\u0099\u0001\u0010<\"\u0005\b\u009a\u0001\u0010>R&\u0010\u009b\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010:\u001a\u0005\b\u009c\u0001\u0010<\"\u0005\b\u009d\u0001\u0010>R\u0018\u0010\u009e\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010:R&\u0010\u009f\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010:\u001a\u0005\b \u0001\u0010<\"\u0005\b¡\u0001\u0010>¨\u0006¤\u0001"}, d2 = {"Lcom/bytedance/android/btm/impl/page/model/PageInfo;", "Lcom/bytedance/android/btm/impl/page/unknown/UnionData;", "Ljava/io/Serializable;", "Lxc/a;", "", "btm", "", "parsePageBtm", "Lcom/bytedance/android/btm/api/PageProp;", "prop", "", "page", "Lcom/bytedance/android/btm/impl/page/model/PageInfoStack;", "infoStack", "setProp", "btmPre", "", "step", "sourcePageId", "", "resetBeforeUpdate", "btmPreIsToken", "putSourceBtm", "Lcom/bytedance/android/btm/impl/page/lifecycle/ResumeFuncOrigin;", "resumeFuncOrigin", "onlyResume", "onResume", "Lcom/bytedance/android/btm/impl/ShowIdUpdateReason;", "reason", "updateShowIdIfNeed", "isFirstResumeV2", "Lcom/bytedance/android/btm/impl/page/model/i;", "pausedInfo", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, "isFromBackground", "copy", "info", BasicTestActionHandler.TEST_ACTION_RESET, "resetDataAfterPageShow", "toString", SVGRenderEngine.SAVE, "data", "parse", "TAG_CLASS_PREFIX", "Ljava/lang/String;", "TAG_SETPROP", "TAG_PUTSOURCEBTM", "TAG_ONRESUME", "TAG_ONPAUSE", "TAG_PARSEPAGEBTM", "TAG_UPDATE_SHOW_ID", "instanceId", "getInstanceId", "()Ljava/lang/String;", "setInstanceId", "(Ljava/lang/String;)V", "reuse", "Z", "getReuse", "()Z", "setReuse", "(Z)V", "pageShowId", "getPageShowId", "setPageShowId", "lastPageShowId", "getLastPageShowId", "setLastPageShowId", "Lcom/bytedance/android/btm/api/model/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/btm/api/model/b;", "getPreBtmIdNode", "()Lcom/bytedance/android/btm/api/model/b;", "setPreBtmIdNode", "(Lcom/bytedance/android/btm/api/model/b;)V", "preBtmIdNode", "b", "getLatestBtmId", "setLatestBtmId", "latestBtmId", "c", "getLatestPageBtmId", "setLatestPageBtmId", "latestPageBtmId", "d", "getLatestBtmIdNode", "setLatestBtmIdNode", "latestBtmIdNode", "e", "getLatestPageBtmIdNode", "setLatestPageBtmIdNode", "latestPageBtmIdNode", "getBtmPre", "setBtmPre", "btmPreSetFromSourceBtmToken", "getBtmPreSetFromSourceBtmToken", "setBtmPreSetFromSourceBtmToken", "getBtmPreIsToken", "setBtmPreIsToken", "btmPreHasCreatedToken", "getBtmPreHasCreatedToken", "setBtmPreHasCreatedToken", "Lcom/bytedance/android/btm/impl/page/unknown/UnionBufferBtm;", "earlierUnionBuffer", "Lcom/bytedance/android/btm/impl/page/unknown/UnionBufferBtm;", "getEarlierUnionBuffer", "()Lcom/bytedance/android/btm/impl/page/unknown/UnionBufferBtm;", "setEarlierUnionBuffer", "(Lcom/bytedance/android/btm/impl/page/unknown/UnionBufferBtm;)V", "I", "getStep", "()I", "setStep", "(I)V", "", "enterTime", "J", "getEnterTime", "()J", "setEnterTime", "(J)V", "duration", "getDuration", "setDuration", "lastResumeTime", "getLastResumeTime", "setLastResumeTime", "lastPauseTime", "getLastPauseTime", "setLastPauseTime", "firstShow", "Ljava/lang/Boolean;", "getFirstShow", "()Ljava/lang/Boolean;", "setFirstShow", "(Ljava/lang/Boolean;)V", "classSimpleName", "getClassSimpleName", "setClassSimpleName", "scene", "getScene", "setScene", "isFirstPage", "setFirstPage", "isBeforeFirstResume", "setBeforeFirstResume", "enterPage", "getEnterPage", "setEnterPage", "enterPage$annotations", "()V", "hasSendEnterPage", "getHasSendEnterPage", "setHasSendEnterPage", "needUpdateShowIdWhenResume", "getNeedUpdateShowIdWhenResume", "setNeedUpdateShowIdWhenResume", "couldUpdateInstanceId", "updateBySourceBtmTokenInThisDisplay", "getUpdateBySourceBtmTokenInThisDisplay", "setUpdateBySourceBtmTokenInThisDisplay", "<init>", "Companion", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public class PageInfo extends UnionData implements xc.a<PageInfo> {
    public static final a Companion = null;
    public static final String SCENE_CRASH = "crash";
    public static final String SCENE_KILL = "kill";
    public static final String SCENE_NORMAL = "normal";
    private static final long serialVersionUID = 20211213;
    private final String TAG_CLASS_PREFIX;
    private final String TAG_ONPAUSE;
    private final String TAG_ONRESUME;
    private final String TAG_PARSEPAGEBTM;
    private final String TAG_PUTSOURCEBTM;
    private final String TAG_SETPROP;
    private final String TAG_UPDATE_SHOW_ID;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient com.bytedance.android.btm.api.model.b f42323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient String f42324b;
    private String btmPre;
    private boolean btmPreHasCreatedToken;
    private boolean btmPreIsToken;
    private boolean btmPreSetFromSourceBtmToken;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f42325c;
    private String classSimpleName;
    private boolean couldUpdateInstanceId;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient com.bytedance.android.btm.api.model.b f42326d;
    private long duration;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient com.bytedance.android.btm.api.model.b f42327e;
    private UnionBufferBtm earlierUnionBuffer;
    private boolean enterPage;
    private long enterTime;
    private Boolean firstShow;
    private boolean hasSendEnterPage;
    private String instanceId;
    private boolean isBeforeFirstResume;
    private boolean isFirstPage;
    private String lastPageShowId;
    private long lastPauseTime;
    private long lastResumeTime;
    private boolean needUpdateShowIdWhenResume;
    private String pageShowId;
    private boolean reuse;
    private String scene;
    private int step;
    private boolean updateBySourceBtmTokenInThisDisplay;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Deprecated(message = "use getForwardPageId instead")
    public static /* synthetic */ void enterPage$annotations() {
    }

    public final void onDestroy() {
    }

    public final void reset() {
        this.step = 1;
        this.btmPre = null;
        this.enterTime = 0;
        this.duration = 0;
        this.lastResumeTime = 0;
        this.lastPauseTime = 0;
        this.scene = "normal";
        if (BtmSetting.f42469d.c().b().M() == 1) goto L6;
        String r100 = this.pageShowId;
        this.lastPageShowId = r100;
        AtomicLong r101 = com.bytedance.android.btm.impl.util.e.f42500a;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(this.instanceId, r100);
        return;
    }

    public PageInfo copy() {
        PageInfoStack.Companion.getClass();
        return copy(PageInfoStack.a.a().create());
    }

    public final boolean isFirstResumeV2() {
        if (BtmSetting.f42469d.c().b().I() != 1) goto L13;
        if (this.isBeforeFirstResume == false) goto L7;
        return true;
    L7:
        if (this.firstShow != null) goto L9;
        return true;
    L9:
        if (this.reuse == true) goto L17;
        return false;
    L17:
        return true;
    L13:
        return this.isBeforeFirstResume;
    }

    public final boolean isFromBackground() {
        boolean r100 = com.bytedance.android.btm.impl.b.f42122a;
        return !com.bytedance.android.btm.impl.b.b().l(this.enterTime, Long.MAX_VALUE).isEmpty();
    }

    public final void resetDataAfterPageShow() {
        if (((Boolean) DuplicatedEnterPageChecker.f42419b.getValue()).booleanValue() == false) goto L25;
        Iterator<Map.Entry<String, DuplicatedEnterPageChecker.a>> r100 = DuplicatedEnterPageChecker.f42418a.entrySet().iterator();
        final ArrayList r101 = new ArrayList();
    L7:
        if (r100.hasNext() == false) goto L22;
        Map.Entry<String, DuplicatedEnterPageChecker.a> r102 = r100.next();
        Map.Entry<String, DuplicatedEnterPageChecker.a> r103 = r102;
        if (Intrinsics.areEqual(r103.getValue().f42423d, getPageShowId()) == false) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L18;
        r102 = null;
    L18:
        Map.Entry<String, DuplicatedEnterPageChecker.a> r105 = r102;
        if (r105 == null) goto L7;
        r101.add(r105.getValue());
        r100.remove();
        goto L7
    L11:
        if (r103.getValue().f42423d == null) goto L14;
        r104 = false;
        goto L15
    L22:
        if (r101.size() <= 1) goto L25;
        Lazy r106 = BtmMonitor.f42159a;
        new DuplicatedEnterPageChecker$monitor$$inlined$monitor$btm_impl_cnRelease$2(r101).run();
    L25:
        final String r107 = this.pageShowId;
        this.enterTime = 0;
        this.duration = 0;
        if (com.bytedance.android.btm.impl.c.f42127a == false) goto L28;
        this.needUpdateShowIdWhenResume = true;
    L29:
        this.couldUpdateInstanceId = true;
        this.hasSendEnterPage = false;
        ALogger.j(ALogger.f41996d, this.TAG_CLASS_PREFIX + "resetDataAfterPageShow", new C98201(this, r107));
        return;
    L28:
        this.lastPageShowId = r107;
        AtomicLong r108 = com.bytedance.android.btm.impl.util.e.f42500a;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(this.instanceId, r107);
        goto L29
    }

    public String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("class_name", getClassName());     // Catch: Throwable -> L6
        r100.put("page_btm", getPageBtm());     // Catch: Throwable -> L6
        r100.put("btm_pre", this.btmPre);     // Catch: Throwable -> L6
        r100.put("btm_pre_from_source_btm_token", this.btmPreSetFromSourceBtmToken);     // Catch: Throwable -> L6
        r100.put("update_token_this_display", this.updateBySourceBtmTokenInThisDisplay);     // Catch: Throwable -> L6
        r100.put("btm_pre_is_token", this.btmPreIsToken);     // Catch: Throwable -> L6
        r100.put("btm_pre_has_created_token", this.btmPreHasCreatedToken);     // Catch: Throwable -> L6
        r100.put("step", this.step);     // Catch: Throwable -> L6
        r100.put("union_pre", getUnionPre());     // Catch: Throwable -> L6
        r100.put("union_step", getUnionStep());     // Catch: Throwable -> L6
        r100.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, getPageId());     // Catch: Throwable -> L6
        r100.put("enter_time", this.enterTime);     // Catch: Throwable -> L6
        r100.put("duration", this.duration);     // Catch: Throwable -> L6
        r100.put("first_show", this.firstShow);     // Catch: Throwable -> L6
        r100.put("scene", this.scene);     // Catch: Throwable -> L6
        r100.put("page_show_id", this.pageShowId);     // Catch: Throwable -> L6
        r100.put("last_page_show_id", this.lastPageShowId);     // Catch: Throwable -> L6
        r100.put("last_resume_time", this.lastResumeTime);     // Catch: Throwable -> L6
        r100.put("last_pause_time", this.lastPauseTime);     // Catch: Throwable -> L6
        r100.put("is_first_page", this.isFirstPage);     // Catch: Throwable -> L6
        r100.put("has_send_enter_page", this.hasSendEnterPage);     // Catch: Throwable -> L6
        r100.put("btm_instance_id", this.instanceId);     // Catch: Throwable -> L6
        r100.put("is_before_first_resume", this.isBeforeFirstResume);     // Catch: Throwable -> L6
        r100.put("reuse", this.reuse);     // Catch: Throwable -> L6
    L5:
        return r100.toString();
    }

    public PageInfo() {
        this.TAG_CLASS_PREFIX = "PageInfo_";
        this.TAG_SETPROP = "PageInfo_setProp";
        this.TAG_PUTSOURCEBTM = "PageInfo_putSourceBtm";
        this.TAG_ONRESUME = "PageInfo_onResume";
        this.TAG_ONPAUSE = "PageInfo_onPause";
        this.TAG_PARSEPAGEBTM = "PageInfo_parsePageBtm";
        this.TAG_UPDATE_SHOW_ID = "PageInfo_updateShowId";
        AtomicLong r100 = com.bytedance.android.btm.impl.util.e.f42500a;
        String r101 = UUID.randomUUID().toString();
        this.instanceId = r101;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(r101, null);
        this.lastPageShowId = "";
        this.step = 1;
        this.scene = "normal";
        this.isBeforeFirstResume = true;
    }

    public String save() {
        return toString();
    }

    public final String getBtmPre() {
        return this.btmPre;
    }

    public final boolean getBtmPreHasCreatedToken() {
        return this.btmPreHasCreatedToken;
    }

    public final boolean getBtmPreIsToken() {
        return this.btmPreIsToken;
    }

    public final boolean getBtmPreSetFromSourceBtmToken() {
        return this.btmPreSetFromSourceBtmToken;
    }

    public final String getClassSimpleName() {
        return this.classSimpleName;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final UnionBufferBtm getEarlierUnionBuffer() {
        return this.earlierUnionBuffer;
    }

    public final boolean getEnterPage() {
        return this.enterPage;
    }

    public final long getEnterTime() {
        return this.enterTime;
    }

    public final Boolean getFirstShow() {
        return this.firstShow;
    }

    public final boolean getHasSendEnterPage() {
        return this.hasSendEnterPage;
    }

    public final String getInstanceId() {
        return this.instanceId;
    }

    public final String getLastPageShowId() {
        return this.lastPageShowId;
    }

    public final long getLastPauseTime() {
        return this.lastPauseTime;
    }

    public final long getLastResumeTime() {
        return this.lastResumeTime;
    }

    public final String getLatestBtmId() {
        return this.f42324b;
    }

    public final com.bytedance.android.btm.api.model.b getLatestBtmIdNode() {
        return this.f42326d;
    }

    public final String getLatestPageBtmId() {
        return this.f42325c;
    }

    public final com.bytedance.android.btm.api.model.b getLatestPageBtmIdNode() {
        return this.f42327e;
    }

    public final boolean getNeedUpdateShowIdWhenResume() {
        return this.needUpdateShowIdWhenResume;
    }

    public final String getPageShowId() {
        return this.pageShowId;
    }

    public final com.bytedance.android.btm.api.model.b getPreBtmIdNode() {
        return this.f42323a;
    }

    public final boolean getReuse() {
        return this.reuse;
    }

    public final String getScene() {
        return this.scene;
    }

    public final int getStep() {
        return this.step;
    }

    public final boolean getUpdateBySourceBtmTokenInThisDisplay() {
        return this.updateBySourceBtmTokenInThisDisplay;
    }

    public final boolean isBeforeFirstResume() {
        return this.isBeforeFirstResume;
    }

    public final boolean isFirstPage() {
        return this.isFirstPage;
    }

    public final PageInfo copy(PageInfo r100) {
        r100.setPageId(getPageId());
        r100.btmPre = this.btmPre;
        r100.setPageBtm(getPageBtm());
        r100.step = this.step;
        r100.enterTime = this.enterTime;
        r100.duration = this.duration;
        r100.lastResumeTime = this.lastResumeTime;
        r100.lastPauseTime = this.lastPauseTime;
        r100.firstShow = this.firstShow;
        r100.setClassName(getClassName());
        r100.scene = this.scene;
        r100.isFirstPage = this.isFirstPage;
        r100.isBeforeFirstResume = this.isBeforeFirstResume;
        r100.pageShowId = this.pageShowId;
        r100.lastPageShowId = this.lastPageShowId;
        r100.instanceId = this.instanceId;
        r100.setUnionPre(getUnionPre());
        r100.setUnionStep(getUnionStep());
        r100.earlierUnionBuffer = this.earlierUnionBuffer;
        r100.f42324b = this.f42324b;
        r100.f42325c = this.f42325c;
        r100.btmPreSetFromSourceBtmToken = this.btmPreSetFromSourceBtmToken;
        r100.updateBySourceBtmTokenInThisDisplay = this.updateBySourceBtmTokenInThisDisplay;
        r100.btmPreIsToken = this.btmPreIsToken;
        r100.btmPreHasCreatedToken = this.btmPreHasCreatedToken;
        r100.reuse = this.reuse;
        return r100;
    }

    public final void onResume(ResumeFuncOrigin r100) {
        updateShowIdIfNeed(ShowIdUpdateReason.PageInfoResume);
        onlyResume(r100);
        PageShowLog.f42410e.getClass();
        PageShowLog.g(this, r100);
    }

    public final void onlyResume(final ResumeFuncOrigin r100) {
        if (BtmPageLifecycleCallbackV2.f42312a == false) goto L5;
        this.isFirstPage = true;
        BtmPageLifecycleCallbackV2.f42312a = false;
    L5:
        this.isBeforeFirstResume = false;
        final PageInfo r101 = copy();
        ALogger r102 = ALogger.f41996d;
        ALogger.j(r102, this.TAG_ONRESUME, new C98161(r101, r100));
        this.lastResumeTime = SystemClock.elapsedRealtime();
        if (this.enterTime > 0) goto L9;
        this.enterTime = System.currentTimeMillis();
        ALogger.j(r102, this.TAG_ONRESUME, new AnonymousClass2(this));
        this.duration = 0;
    L9:
        if (this.reuse == false) goto L22;
        BtmSetting r103 = BtmSetting.f42469d;
        if (r103.c().c().t() == 0) goto L22;
        if ((r103.c().c().t() & 1) == 0) goto L16;
        this.firstShow = null;
        this.duration = 0;
    L16:
        if ((r103.c().c().t() & 2) == 0) goto L22;
        if (this.couldUpdateInstanceId == false) goto L22;
        this.couldUpdateInstanceId = false;
        AtomicLong r104 = com.bytedance.android.btm.impl.util.e.f42500a;
        this.instanceId = UUID.randomUUID().toString();
        if (r103.c().c().x() != 1) goto L22;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(this.instanceId, null);
    L22:
        Boolean r105 = this.firstShow;
        if (r105 != null) goto L26;
        final boolean r106 = this.reuse;
        ALogger.j(r102, this.TAG_ONRESUME, new AnonymousClass3(r106));
        this.firstShow = Boolean.TRUE;
    L30:
        this.reuse = false;
        return;
    L26:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L30;
        if (this.duration != 0) goto L30;
        ALogger.j(r102, this.TAG_ONRESUME, AnonymousClass4.INSTANCE);
        this.firstShow = Boolean.FALSE;
        goto L30
    }

    public PageInfo parse(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L13
        setClassName(r101.optString("class_name"));     // Catch: Exception -> L13
        String r102 = r101.optString("page_btm");     // Catch: Exception -> L13
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r102 = null;
    L11:
        setPageBtm(r102);     // Catch: Exception -> L13
        this.btmPre = r101.optString("btm_pre");     // Catch: Exception -> L13
        this.btmPreSetFromSourceBtmToken = r101.optBoolean("btm_pre_from_source_btm_token");     // Catch: Exception -> L13
        this.updateBySourceBtmTokenInThisDisplay = r101.optBoolean("update_token_this_display");     // Catch: Exception -> L13
        this.btmPreIsToken = r101.optBoolean("btm_pre_is_token");     // Catch: Exception -> L13
        this.btmPreHasCreatedToken = r101.optBoolean("btm_pre_has_created_token");     // Catch: Exception -> L13
        this.step = r101.optInt("step");     // Catch: Exception -> L13
        setUnionPre(r101.optString("union_pre"));     // Catch: Exception -> L13
        setUnionStep(r101.optInt("union_step"));     // Catch: Exception -> L13
        setPageId(r101.optString(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID));     // Catch: Exception -> L13
        this.enterTime = r101.optLong("enter_time");     // Catch: Exception -> L13
        this.duration = r101.optLong("duration");     // Catch: Exception -> L13
        this.firstShow = Boolean.valueOf(r101.optBoolean("first_show"));     // Catch: Exception -> L13
        this.scene = r101.optString("scene");     // Catch: Exception -> L13
        this.pageShowId = r101.optString("page_show_id");     // Catch: Exception -> L13
        this.lastPageShowId = r101.optString("last_page_show_id");     // Catch: Exception -> L13
        this.lastResumeTime = r101.optLong("last_resume_time");     // Catch: Exception -> L13
        this.lastPauseTime = r101.optLong("last_pause_time");     // Catch: Exception -> L13
        this.isFirstPage = r101.optBoolean("is_first_page");     // Catch: Exception -> L13
        this.isBeforeFirstResume = r101.optBoolean("is_before_first_resume", true);     // Catch: Exception -> L13
        this.hasSendEnterPage = r101.optBoolean("has_send_enter_page", true);     // Catch: Exception -> L13
        this.instanceId = r101.optString("btm_instance_id");     // Catch: Exception -> L13
        goto L12
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
    L12:
        return this;
    }

    public final void parsePageBtm(final String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        ALogger.j(ALogger.f41996d, this.TAG_PARSEPAGEBTM, C98171.INSTANCE);
        return;
    L12:
        List r101 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        if (r101.size() != 1) goto L18;
        if (StringsKt.startsWith$default((String) ListProtector.get(r101, 0), "b", false, 2, null) == false) goto L18;
        setPageBtm(BtmHostDependManager.F.d() + "." + ((String) ListProtector.get(r101, 0)) + ".c0.d0");
    L25:
        ALogger.j(ALogger.f41996d, this.TAG_PARSEPAGEBTM, new C98182(r110));
        return;
    L18:
        if (StringsKt.contains$default(r110, "bUnknown", false, 2, null) == false) goto L21;
        setPageBtm(r110);
        goto L25
    L21:
        if (StringsKt.startsWith$default((String) ListProtector.get(r101, 0), BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, false, 2, null) == true) goto L23;
    L27:
        com.bytedance.android.btm.api.inner.g.a.b(BtmMonitor.f42161c, 1102, r110 + ", format error", null, false, 28);
        return;
    L23:
        if (r101.size() < 2) goto L27;
        setPageBtm(((String) ListProtector.get(r101, 0)) + "." + ((String) ListProtector.get(r101, 1)) + ".c0.d0");
        goto L25
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    public final void setBeforeFirstResume(boolean r100) {
        this.isBeforeFirstResume = r100;
    }

    public final void setBtmPre(String r100) {
        this.btmPre = r100;
    }

    public final void setBtmPreHasCreatedToken(boolean r100) {
        this.btmPreHasCreatedToken = r100;
    }

    public final void setBtmPreIsToken(boolean r100) {
        this.btmPreIsToken = r100;
    }

    public final void setBtmPreSetFromSourceBtmToken(boolean r100) {
        this.btmPreSetFromSourceBtmToken = r100;
    }

    public final void setClassSimpleName(String r100) {
        this.classSimpleName = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setEarlierUnionBuffer(UnionBufferBtm r100) {
        this.earlierUnionBuffer = r100;
    }

    public final void setEnterPage(boolean r100) {
        this.enterPage = r100;
    }

    public final void setEnterTime(long r100) {
        this.enterTime = r100;
    }

    public final void setFirstPage(boolean r100) {
        this.isFirstPage = r100;
    }

    public final void setFirstShow(Boolean r100) {
        this.firstShow = r100;
    }

    public final void setHasSendEnterPage(boolean r100) {
        this.hasSendEnterPage = r100;
    }

    public final void setInstanceId(String r100) {
        this.instanceId = r100;
    }

    public final void setLastPageShowId(String r100) {
        this.lastPageShowId = r100;
    }

    public final void setLastPauseTime(long r100) {
        this.lastPauseTime = r100;
    }

    public final void setLastResumeTime(long r100) {
        this.lastResumeTime = r100;
    }

    public final void setLatestBtmId(String r100) {
        this.f42324b = r100;
    }

    public final void setLatestBtmIdNode(com.bytedance.android.btm.api.model.b r100) {
        this.f42326d = r100;
    }

    public final void setLatestPageBtmId(String r100) {
        this.f42325c = r100;
    }

    public final void setLatestPageBtmIdNode(com.bytedance.android.btm.api.model.b r100) {
        this.f42327e = r100;
    }

    public final void setNeedUpdateShowIdWhenResume(boolean r100) {
        this.needUpdateShowIdWhenResume = r100;
    }

    public final void setPageShowId(String r100) {
        this.pageShowId = r100;
    }

    public final void setPreBtmIdNode(com.bytedance.android.btm.api.model.b r100) {
        this.f42323a = r100;
    }

    public final void setReuse(boolean r100) {
        this.reuse = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setStep(int r100) {
        this.step = r100;
    }

    public final void setUpdateBySourceBtmTokenInThisDisplay(boolean r100) {
        this.updateBySourceBtmTokenInThisDisplay = r100;
    }

    public final void updateShowIdIfNeed(final ShowIdUpdateReason r100) {
        if (this.needUpdateShowIdWhenResume == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.btm.impl.c.f42127a == false) goto L9;
        final PageInfo r101 = copy();
        ALogger.j(ALogger.f41996d, this.TAG_UPDATE_SHOW_ID, new C98221(r101, r100));
        this.needUpdateShowIdWhenResume = false;
        String r102 = this.pageShowId;
        this.lastPageShowId = r102;
        AtomicLong r103 = com.bytedance.android.btm.impl.util.e.f42500a;
        this.pageShowId = com.bytedance.android.btm.impl.util.e.a(this.instanceId, r102);
        return;
    }

    public /* bridge */ /* synthetic */ Object parse(String r100) {
        return parse(r100);
    }

    public void onPause(Object r110, i r111) {
        final PageInfo r112 = copy();
        Flag r100 = null;
        if (r111 == null) goto L5;
        final String r101 = r111.toString();
    L6:
        ALogger.j(ALogger.f41996d, this.TAG_ONPAUSE, new AnonymousClass1(r112, r101));
        long r102 = SystemClock.elapsedRealtime();
        this.lastPauseTime = r102;
        long r103 = this.lastResumeTime;
        if (r103 <= 0) goto L9;
        this.duration += r102 - r103;
    L10:
        BtmChainRecorder r113 = com.bytedance.android.btm.impl.b.f42126e.c();
        r113.f42135h.put(this.pageShowId, Long.valueOf(this.duration));
        if (r111 == null) goto L13;
        Flag r114 = r111.f42367c;
    L15:
        if (r114 != Flag.BACKGROUND) goto L17;
        com.bytedance.android.btm.impl.util.d r115 = com.bytedance.android.btm.impl.util.d.f42499a;
    L29:
        this.updateBySourceBtmTokenInThisDisplay = false;
        return;
    L17:
        if (r111 == null) goto L19;
        Flag r116 = r111.f42367c;
    L21:
        if (r116 != Flag.FORWARD) goto L23;
        PageShowLog.f42410e.k(this, r111, false);
        goto L29
    L23:
        if (r111 == null) goto L26;
        r100 = r111.f42367c;
    L26:
        if (r100 != Flag.BACK) goto L28;
        PageShowLog.f42410e.k(this, r111, true);
        goto L29
    L28:
        com.bytedance.android.btm.impl.util.d r117 = com.bytedance.android.btm.impl.util.d.f42499a;
        goto L29
    L19:
        r116 = null;
        goto L21
    L13:
        r114 = null;
        goto L15
    L9:
        com.bytedance.android.btm.api.inner.g.a.b(BtmMonitor.f42161c, 1104, "lastResumeTime is " + this.lastResumeTime, null, false, 28);
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final void setProp(final PageProp r100, Object r101, PageInfoStack r102) {
        if (BtmSetting.f42469d.c().b().i() != 1) goto L5;
        r100.setAuto(true);
    L5:
        final String r103 = r101.getClass().getName();
        ALogger.j(ALogger.f41996d, this.TAG_SETPROP, new C98211(r100, r103));
        parsePageBtm(r100.getBtm());
        setClassName(r101.getClass().getName());
        this.classSimpleName = r101.getClass().getSimpleName();
        r102.setPageProp(r100);
    }

    public static /* synthetic */ void onPause$default(PageInfo r100, Object r101, i r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.onPause(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPause");
    }

    public final void putSourceBtm(final String r100, final int r101, final String r102, boolean r110, boolean r111) {
        ALogger.j(ALogger.f41996d, this.TAG_PUTSOURCEBTM, new C98191(this, r100, r101, r102));
        if (Intrinsics.areEqual(getPageId(), r102) == false) goto L6;
        com.bytedance.android.btm.api.inner.g.a.b(BtmMonitor.f42161c, 1123, "pre=" + r100 + ", step=" + r101, null, false, 28);
        return;
    L6:
        if (r110 == false) goto L8;
        reset();
    L8:
        this.btmPre = r100;
        this.step = r101;
        this.btmPreIsToken = r111;
        boolean r103 = true;
        if (r111 == false) goto L11;
        this.btmPreHasCreatedToken = true;
        return;
    L11:
        Map<String, BufferBtm> r104 = BufferQueue.f42241k;
        monitor-enter(r104);
        Iterator<Map.Entry<String, BufferBtm>> r112 = r104.entrySet().iterator();     // Catch: Throwable -> L25
    L15:
        if (r112.hasNext() == false) goto L20;
        Map.Entry<String, BufferBtm> r113 = r112.next();     // Catch: Throwable -> L25
        Lazy r105 = BtmFormatUtils.f42489a;     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(r100, BtmFormatUtils.g(r113.getKey())) == false) goto L15;
        monitor-exit(r104);
    L23:
        this.btmPreHasCreatedToken = r103;
        return;
    L20:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r104);
        r103 = false;
    L25:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void putSourceBtm$default(PageInfo r100, String r101, int r102, String r103, boolean r110, boolean r111, int r112, Object r113) {
        if (r113 != null) goto L14;
        if ((r112 & 8) == 0) goto L6;
        boolean r104 = true;
    L8:
        if ((r112 & 16) == 0) goto L10;
        boolean r105 = false;
    L11:
        r100.putSourceBtm(r101, r102, r103, r104, r105);
        return;
    L10:
        r105 = r111;
        goto L11
    L6:
        r104 = r110;
        goto L8
    L14:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: putSourceBtm");
    }
}
