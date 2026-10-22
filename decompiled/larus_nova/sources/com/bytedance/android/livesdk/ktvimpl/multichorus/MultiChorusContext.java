package com.bytedance.android.livesdk.ktvimpl.multichorus;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import jd2.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import vm2.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/multichorus/MultiChorusContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/ktvapi/util/a;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "", "", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/a;", "audienceApplyMultiChorusInfoMap", "Ljava/util/Map;", "getAudienceApplyMultiChorusInfoMap", "()Ljava/util/Map;", "", "oneSongAccumulatorMultiChorusUserCount", "I", "getOneSongAccumulatorMultiChorusUserCount", "()I", "setOneSongAccumulatorMultiChorusUserCount", "(I)V", "Lcom/bytedance/live/datacontext/m;", "", "openAudienceMultiChorusSwitch$delegate", "getOpenAudienceMultiChorusSwitch", "()Lcom/bytedance/live/datacontext/m;", "openAudienceMultiChorusSwitch", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiChorusContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String MULTI_CHORUS_ENABLE_KEY = "linkmic_multi_chorus";
    public static final int NEW_VERSION = 1;
    public static final int OLD_VERSION = 0;
    public static final String TAG = "MultiChorusContext";
    private final Map<String, com.bytedance.android.livesdk.ktvimpl.multichorus.model.a> audienceApplyMultiChorusInfoMap;
    private int oneSongAccumulatorMultiChorusUserCount;
    private final p openAudienceMultiChorusSwitch$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean d() {
            int r100 = ((Number) h.X3.getValue(null, h.f556082a[256(0x100, float:3.59E-43)])).intValue();
            if (r100 == 0) goto L9;
            if (r100 != 1) goto L6;
        L20:
            int r101 = 0;
        L21:
            if (r101 <= 0) goto L24;
            return true;
        L24:
            return false;
        L6:
            if (r100 != 2) goto L20;
            r101 = 1;
            goto L21
        L9:
            o r102 = m.i();
            if (r102 == null) goto L20;
            com.bytedance.live.datacontext.m<IRoom> r103 = r102.getRoom();
            if (r103 == null) goto L20;
            IRoom r104 = r103.getValue();
            if (r104 == null) goto L20;
            Map<String, String> r105 = r104.getAnchorABMap();
            if (r105 == null) goto L20;
            String r106 = r105.get(MultiChorusContext.MULTI_CHORUS_ENABLE_KEY);
            if (r106 == null) goto L20;
            r101 = CastIntegerProtector.parseInt(r106);
            goto L21
        }

        @JvmStatic
        public final MultiChorusContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(MultiChorusContext.class);
            if ((r100 instanceof MultiChorusContext) == true) goto L6;
            r100 = null;
        L6:
            return (MultiChorusContext) r100;
        }

        @JvmStatic
        public final int a() {
            MultiChorusContext r100 = getContext();
            if (r100 == null) goto L9;
            j<com.bytedance.android.livesdk.ktvapi.util.a> r101 = r100.m8261getService();
            if (r101 == null) goto L9;
            com.bytedance.android.livesdk.ktvapi.util.a r102 = r101.getValue();
            if (r102 == null) goto L9;
            return r102.i0();
        L9:
            return 0;
        }

        @JvmStatic
        public final boolean b() {
            if (a() != 1) goto L5;
            return true;
        L5:
            if (a() == 2) goto L10;
            return false;
        L10:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final boolean c() {
            MultiChorusContext r100 = getContext();
            if (r100 == null) goto L9;
            com.bytedance.live.datacontext.m r101 = MultiChorusContext.access$getOpenAudienceMultiChorusSwitch$p(r100);
            if (r101 == null) goto L9;
            Boolean r102 = (Boolean) r101.getValue();
            if (r102 == null) goto L9;
            boolean r103 = r102.booleanValue();
        L10:
            if (r103 == false) goto L23;
            KtvComponentContext r104 = KtvComponentContext.Companion.getContext();
            if (r104 == null) goto L16;
            n<Integer> r105 = r104.getKtvComponentStatus();
            if (r105 == null) goto L16;
            Integer r106 = r105.getValue();
        L17:
            if (r106 != null) goto L20;
            return false;
        L20:
            if (r106.intValue() != 1) goto L24;
            return true;
        L24:
            return false;
        L16:
            r106 = null;
            goto L17
        L23:
            return false;
        L9:
            r103 = false;
            goto L10
        }

        @JvmStatic
        public final jd2.d j() {
            MultiChorusContext r100 = getContext();
            if (r100 == null) goto L9;
            j<com.bytedance.android.livesdk.ktvapi.util.a> r101 = r100.m8261getService();
            if (r101 == null) goto L9;
            com.bytedance.android.livesdk.ktvapi.util.a r102 = r101.getValue();
            if (r102 == null) goto L9;
            return r102.Ze();
        L9:
            return null;
        }

        @JvmStatic
        public final List<e> k() {
            MultiChorusContext r100 = getContext();
            if (r100 == null) goto L9;
            j<com.bytedance.android.livesdk.ktvapi.util.a> r101 = r100.m8261getService();
            if (r101 == null) goto L9;
            com.bytedance.android.livesdk.ktvapi.util.a r102 = r101.getValue();
            if (r102 == null) goto L9;
            return r102.Sh();
        L9:
            return null;
        }

        @JvmStatic
        public final Disposable g(Consumer<Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "observer");
            MultiChorusContext r101 = getContext();
            if (r101 == null) goto L9;
            com.bytedance.live.datacontext.m r102 = MultiChorusContext.access$getOpenAudienceMultiChorusSwitch$p(r101);
            if (r102 == null) goto L9;
            Observable r103 = r102.a();
            if (r103 == null) goto L9;
            return r103.subscribe(r100);
        L9:
            return null;
        }

        @JvmStatic
        public final void m(boolean r100) {
            MultiChorusContext r101 = getContext();
            if (r101 == null) goto L8;
            com.bytedance.live.datacontext.m r102 = MultiChorusContext.access$getOpenAudienceMultiChorusSwitch$p(r101);
            if (r102 == null) goto L9;
            r102.setValue(Boolean.valueOf(r100));
            return;
        L9:
            return;
        }

        @JvmStatic
        public final void h(LifecycleOwner r100, Observer<List<e>> r101) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r101, "observer");
            MultiChorusContext r102 = getContext();
            if (r102 == null) goto L10;
            j<com.bytedance.android.livesdk.ktvapi.util.a> r103 = r102.m8261getService();
            if (r103 == null) goto L11;
            com.bytedance.android.livesdk.ktvapi.util.a r104 = r103.getValue();
            if (r104 == null) goto L12;
            r104.r9(r100, r101);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void i(LifecycleOwner r100, Observer<com.bytedance.android.livesdk.ktvapi.util.e> r101) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r101, "observer");
            MultiChorusContext r102 = getContext();
            if (r102 == null) goto L10;
            j<com.bytedance.android.livesdk.ktvapi.util.a> r103 = r102.m8261getService();
            if (r103 == null) goto L11;
            com.bytedance.android.livesdk.ktvapi.util.a r104 = r103.getValue();
            if (r104 == null) goto L12;
            r104.Gd(r100, r101);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void e(MusicPanel r100, Function1<Object, Unit> r101, Function1<? super Throwable, Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, "music");
            Intrinsics.checkNotNullParameter(r101, "successCallback");
            Intrinsics.checkNotNullParameter(r102, "failCallback");
            MultiChorusContext r103 = getContext();
            if (r103 == null) goto L10;
            j<com.bytedance.android.livesdk.ktvapi.util.a> r104 = r103.m8261getService();
            if (r104 == null) goto L11;
            com.bytedance.android.livesdk.ktvapi.util.a r105 = r104.getValue();
            if (r105 == null) goto L12;
            r105.Vi(r100, r101, r102);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void f(MusicPanel r100, Function1<? super com.bytedance.android.live.network.response.e<Object>, Unit> r101, Function1<? super Throwable, Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, "music");
            Intrinsics.checkNotNullParameter(r101, "successCallback");
            Intrinsics.checkNotNullParameter(r102, "failCallback");
            MultiChorusContext r103 = getContext();
            if (r103 == null) goto L10;
            j<com.bytedance.android.livesdk.ktvapi.util.a> r104 = r103.m8261getService();
            if (r104 == null) goto L11;
            com.bytedance.android.livesdk.ktvapi.util.a r105 = r104.getValue();
            if (r105 == null) goto L12;
            r105.gj(r100, r101, r102);
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public final void l(IBaseUser r100, h80.a<Boolean> r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "user");
            Intrinsics.checkNotNullParameter(r101, "consumer");
            Intrinsics.checkNotNullParameter(r102, "requestPage");
            MultiChorusContext r103 = getContext();
            if (r103 == null) goto L9;
            j<com.bytedance.android.livesdk.ktvapi.util.a> r104 = r103.m8261getService();
            if (r104 == null) goto L9;
            com.bytedance.android.livesdk.ktvapi.util.a r105 = r104.getValue();
            if (r105 == null) goto L9;
            r105.i5(r100, r101, r102);
        L9:
            IInteractService r106 = (IInteractService) k.f(IInteractService.class);
            if (r106 == null) goto L13;
            r106.logPermit(r100, r102);
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiChorusContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiChorusContext.class, "openAudienceMultiChorusSwitch", "getOpenAudienceMultiChorusSwitch()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final MultiChorusContext getContext() {
        return Companion.getContext();
    }

    @JvmStatic
    public static final int getMultiChorusRole() {
        return Companion.a();
    }

    private final com.bytedance.live.datacontext.m<Boolean> getOpenAudienceMultiChorusSwitch() {
        return (com.bytedance.live.datacontext.m) this.openAudienceMultiChorusSwitch$delegate.a(this, $$delegatedProperties[1]);
    }

    @JvmStatic
    public static final boolean hasEnterMultiChorusQueue() {
        return Companion.b();
    }

    @JvmStatic
    public static final boolean isInMultiChorus() {
        return Companion.c();
    }

    @JvmStatic
    public static final boolean isMultiChorusEnable() {
        Companion.getClass();
        return a.d();
    }

    @JvmStatic
    public static final void joinMultiChorus(MusicPanel r100, Function1<Object, Unit> r101, Function1<? super Throwable, Unit> r102) {
        Companion.e(r100, r101, r102);
    }

    @JvmStatic
    public static final void leaveMultiChorus(MusicPanel r100, Function1<? super com.bytedance.android.live.network.response.e<Object>, Unit> r101, Function1<? super Throwable, Unit> r102) {
        Companion.f(r100, r101, r102);
    }

    @JvmStatic
    public static final Disposable observeMultiChorusSwitchState(Consumer<Boolean> r100) {
        return Companion.g(r100);
    }

    @JvmStatic
    public static final void observeMultiChorusUserList(LifecycleOwner r100, Observer<List<e>> r101) {
        Companion.h(r100, r101);
    }

    @JvmStatic
    public static final void observeMusicJoinStatus(LifecycleOwner r100, Observer<com.bytedance.android.livesdk.ktvapi.util.e> r101) {
        Companion.i(r100, r101);
    }

    @JvmStatic
    public static final jd2.d obtainMultiChorusData() {
        return Companion.j();
    }

    @JvmStatic
    public static final List<e> obtainMultiChorusUserList() {
        return Companion.k();
    }

    @JvmStatic
    public static final void permit(IBaseUser r100, h80.a<Boolean> r101, String r102) {
        Companion.l(r100, r101, r102);
    }

    @JvmStatic
    public static final void updateMultiChorusSwitchState(boolean r100) {
        Companion.m(r100);
    }

    /* JADX INFO: renamed from: getService, reason: collision with other method in class */
    public final j<com.bytedance.android.livesdk.ktvapi.util.a> m8261getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.ktvapi.util.a getService() {
        MultiChorusContext r100 = Companion.getContext();
        if (r100 == null) goto L7;
        j<com.bytedance.android.livesdk.ktvapi.util.a> r101 = r100.m8261getService();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @JvmStatic
    public static final boolean isLeadSinger() {
        if (Companion.a() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.ktvapi.util.e obtainMusicJoinStatus() {
        MultiChorusContext r100 = Companion.getContext();
        if (r100 == null) goto L9;
        j<com.bytedance.android.livesdk.ktvapi.util.a> r101 = r100.m8261getService();
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.util.a r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.bj();
    L9:
        return null;
    }

    public MultiChorusContext() {
        this.service$delegate = ConstantKt.c(this);
        this.audienceApplyMultiChorusInfoMap = new LinkedHashMap();
        this.openAudienceMultiChorusSwitch$delegate = q.d(this, Boolean.FALSE);
    }

    public final Map<String, com.bytedance.android.livesdk.ktvimpl.multichorus.model.a> getAudienceApplyMultiChorusInfoMap() {
        return this.audienceApplyMultiChorusInfoMap;
    }

    public final int getOneSongAccumulatorMultiChorusUserCount() {
        return this.oneSongAccumulatorMultiChorusUserCount;
    }

    public static final /* synthetic */ com.bytedance.live.datacontext.m access$getOpenAudienceMultiChorusSwitch$p(MultiChorusContext r100) {
        return r100.getOpenAudienceMultiChorusSwitch();
    }

    @JvmStatic
    public static final void cancelApply(h80.a<Boolean> r100) {
        MultiChorusContext r101 = Companion.getContext();
        if (r101 == null) goto L10;
        j<com.bytedance.android.livesdk.ktvapi.util.a> r102 = r101.m8261getService();
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.ktvapi.util.a r103 = r102.getValue();
        if (r103 == null) goto L12;
        r103.cancelApply(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final void cancelMultiChorusApplyInEnd(h80.a<Boolean> r100) {
        MultiChorusContext r101 = Companion.getContext();
        if (r101 == null) goto L10;
        j<com.bytedance.android.livesdk.ktvapi.util.a> r102 = r101.m8261getService();
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.ktvapi.util.a r103 = r102.getValue();
        if (r103 == null) goto L12;
        r103.z9(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setOneSongAccumulatorMultiChorusUserCount(int r100) {
        this.oneSongAccumulatorMultiChorusUserCount = r100;
    }
}
