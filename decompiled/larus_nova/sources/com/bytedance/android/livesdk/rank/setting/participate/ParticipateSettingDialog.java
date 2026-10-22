package com.bytedance.android.livesdk.rank.setting.participate;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/rank/setting/participate/ParticipateSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParticipateSettingDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f156991k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f156992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f156993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompositeDisposable f156994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ParticipateSettingViewModel f156995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IParticipateSettingApi f156996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f156997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ParticipateSettingDialog$adapter$1 f156998j;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f157003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f157004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Switch f157005c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f157003a, r101.f157003a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f157004b, r101.f157004b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f157005c, r101.f157005c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            TextView r100 = this.f157003a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            TextView r104 = this.f157004b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Switch r107 = this.f157005c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ViewHolder(textLine1=" + this.f157003a + ", textLine2=" + this.f157004b + ", switch=" + this.f157005c + ")";
        }

        public b(TextView r100, TextView r101, Switch r102) {
            Intrinsics.checkNotNullParameter(r100, "textLine1");
            Intrinsics.checkNotNullParameter(r101, "textLine2");
            Intrinsics.checkNotNullParameter(r102, "switch");
            this.f157003a = r100;
            this.f157004b = r101;
            this.f157005c = r102;
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {
        public c() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean shouldInterceptSlide(int r100) {
            return false;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParticipateSettingDialog f157006a;

        public d(ParticipateSettingDialog r100) {
            this.f157006a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (r101 == null) goto L7;
            ((TextView) this.f157006a.S90(R.id.participate_setting_title)).setText(r101);
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParticipateSettingDialog f157007a;

        public e(ParticipateSettingDialog r100) {
            this.f157007a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (r101 == null) goto L7;
            ((TextView) this.f157007a.S90(R.id.participate_setting_subtitle)).setText(r101);
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParticipateSettingDialog f157008a;

        public f(ParticipateSettingDialog r100) {
            this.f157008a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((List) r100) == null) goto L7;
            this.f157008a.f156998j.notifyDataSetChanged();
            return;
        }
    }

    static {
    }

    public final i U90() {
        return (i) this.f156997i.getValue();
    }

    public ParticipateSettingDialog() {
        this.f156992d = new LinkedHashMap();
        this.f156996h = (IParticipateSettingApi) ((com.bytedance.android.livesdk.revenue.service.network.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.network.a.class)).getService(IParticipateSettingApi.class);
        this.f156997i = LazyKt.lazy(new ParticipateSettingDialog$logger$2(this));
        this.f156998j = new ParticipateSettingDialog$adapter$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        CompositeDisposable r100 = this.f156994f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cd");
    L5:
        r100.dispose();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f156992d.clear();
    }

    public static final /* synthetic */ ParticipateSettingViewModel T90(ParticipateSettingDialog r100) {
        ParticipateSettingViewModel r101 = r100.f156995g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    public final View S90(int r100) {
        if (this.f156992d != null) goto L5;
        this.f156992d = new LinkedHashMap();
    L5:
        View r101 = this.f156992d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f156992d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Context r101 = getContext();
        if (r101 == null) goto L64;
        setBottomSheetSlideProcessor(new c());
        Dialog r102 = getDialog();
        if (r102 == null) goto L16;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L16;
        r103.setGravity(80);
        r103.setLayout(-1, -1);
        r103.setBackgroundDrawable(new ColorDrawable(0));
    L16:
        a1.k(S90(R.id.participate_setting_container), (int) fm3.e.a(r101, 484.0f));
        ListView r104 = (ListView) S90(R.id.participate_setting_switch_list);
        Long r105 = null;
        r104.setDivider(null);
        r104.setClickable(false);
        r104.setOnItemClickListener(null);
        r104.setAdapter(this.f156998j);
        ParticipateSettingViewModel r106 = this.f156995g;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        r106.getTitle().observeForever(new d(this));
        ParticipateSettingViewModel r107 = this.f156995g;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r107.getSubtitle().observeForever(new e(this));
        ParticipateSettingViewModel r108 = this.f156995g;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        r108.getSettingItems().observeForever(new f(this));
        i r109 = U90();
        Pair[] r110 = new Pair[2];
        k r111 = r109.f157033a;
        if (r111 == null) goto L30;
        IRoom r112 = r111.getRoom();
        if (r112 == null) goto L30;
        String r113 = r112.getOwnerUserIdString();
    L31:
        r110[0] = TuplesKt.to("anchor_id", String.valueOf(r113));
        k r114 = r109.f157033a;
        if (r114 == null) goto L36;
        IRoom r115 = r114.getRoom();
        if (r115 == null) goto L36;
        r105 = Long.valueOf(r115.getRoomId());
    L36:
        r110[1] = TuplesKt.to("room_id", String.valueOf(r105));
        Map<? extends String, ? extends String> r116 = MapsKt.mapOf(r110);
        n r117 = new n();
        Map<String, String> r118 = r117.f516447a;
        Intrinsics.checkNotNullParameter(r118, "map");
        Intrinsics.checkNotNullParameter(r116, "map");
        r118.putAll(r116);
        m r119 = new m();
        r119.b(LogCommon.ROOM);
        ((ArrayList) r117.f516448b).addAll(r119.f516446a);
        cy0.e.f465759a.getClass();
        j r120 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r121 = com.bytedance.android.scope.m.b(r120).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r121);
        ((mz0.i) ((f80.a) r121)).w3("livesdk_anchor_ranklist_setting_banner_show", r117.f516447a, r117.f516448b);
        k r122 = this.f156993e;
        if (r122 == null) goto L42;
        IRoom r123 = r122.getRoom();
        if (r123 == null) goto L42;
        String r124 = r123.getOwnerUserIdString();
        if (r124 == null) goto L42;
    L43:
        String r125 = r124;
        k r126 = this.f156993e;
        if (r126 == null) goto L48;
        IRoom r127 = r126.getRoom();
        if (r127 == null) goto L48;
        long r128 = r127.getRoomId();
    L49:
        long r129 = r128;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L55
        Disposable r131 = RxUtilKt.h(this.f156996h.getStatusList(r129, d5.c(r125), r125)).subscribe(new com.bytedance.android.livesdk.rank.setting.participate.b(this), new com.bytedance.android.livesdk.rank.setting.participate.c(this));     // Catch: Throwable -> L55
        CompositeDisposable r132 = this.f156994f;     // Catch: Throwable -> L55
        if (r132 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("cd");     // Catch: Throwable -> L55
    L53:
        RxUtilKt.c(r131, r132);     // Catch: Throwable -> L55
        Object r133 = Result.m9449constructorimpl(r131);     // Catch: Throwable -> L55
    L57:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L60;
        ALogger.e("ParticipateSetting", "fetchSettings error + " + r134.getMessage());
    L60:
        int r135 = b1.f158888a;
        b1.b(true, new ParticipateSettingDialog$initDialogUI$1(this));
        return;
    L55:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L48:
        r128 = 0;
    L42:
        r124 = "";
    L30:
        r113 = null;
        goto L31
    L64:
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r137 = DialogFragmentLancet.sLastShowStack;
        if (r137 == null) goto L66;
        com.bytedance.crash.d.d(r137, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_common_bottom_dialog);
        this.f156994f = new CompositeDisposable();
        this.f156995g = (ParticipateSettingViewModel) ViewModelProviders.of(this).get(ParticipateSettingViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_anchor_participate_rank_setting_dialog, r101, false);
    }
}
