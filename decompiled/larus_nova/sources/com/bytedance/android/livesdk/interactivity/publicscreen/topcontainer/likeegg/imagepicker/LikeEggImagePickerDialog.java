package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/LikeEggImagePickerDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "Companion", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LikeEggImagePickerDialog extends DialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f139944o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super String, Unit> f139945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f139946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataCenter f139947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f139948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f139949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f139950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImagePickViewModel f139951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageItemAdapter f139952k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LikeEggImagePickerDialog$initImageRecyclerView$4 f139953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f139954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f139955n;

    public static final class Companion {
        public static void a(final Context r100, final Function1 r101, final Function0 r102, final DataCenter r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "clickAction");
            Intrinsics.checkNotNullParameter(r102, "cancelAction");
            ALogger.d("LikeEggImagePickerDialog", "start launch");
            TokenCert r104 = LikeEggHelper.f140022a;
            LikeEggHelper.c(new LikeEggImagePickerDialog$Companion$launch$1(r100, r101, r102, r103), LikeEggImagePickerDialog$Companion$launch$2.INSTANCE);
        }
    }

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LikeEggImagePickerDialog f139956a;

        public a(LikeEggImagePickerDialog r100) {
            this.f139956a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            LikeEggImagePickerDialog r102 = this.f139956a;
            int r103 = LikeEggImagePickerDialog.f139944o;
            r102.S90();
        }
    }

    static {
    }

    public final void S90() {
        View r100 = this.f139950i;
        if (r100 == null) goto L6;
        TokenCert r101 = LikeEggHelper.f140022a;
        a1.k(r100, LikeEggHelper.a(this.f139947f));
    L6:
        if (PadConfigUtils.c() == false) goto L20;
        View r102 = this.f139950i;
        if (r102 == null) goto L10;
        a1.o(r102, UtilityKotlinExtentionsKt.i(20));
    L10:
        View r103 = this.f139950i;
        if (r103 == null) goto L13;
        a1.n(r103, UtilityKotlinExtentionsKt.i(20) - 2);
    L13:
        View r104 = this.f139950i;
        if (r104 == null) goto L16;
        a1.l(r104, UtilityKotlinExtentionsKt.i(20));
    L16:
        View r105 = this.f139950i;
        if (r105 == null) goto L21;
        a1.p(r105, UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
        return;
    L21:
        return;
    }

    public LikeEggImagePickerDialog() {
        this.f139955n = new CompositeDisposable();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ImagePickViewModel r100 = this.f139951j;
        if (r100 == null) goto L6;
        r100.tryFirstTimeLoad();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setGravity(80);
        r102.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (PadConfigUtils.c() == false) goto L5;
        setStyle(1, R.style.ttlive_like_egg_image_picker_pad);
    L6:
        this.f139951j = (ImagePickViewModel) ViewModelProviders.of(this).get(ImagePickViewModel.class);
        Activity r101 = ContextUtil.contextToActivity(getContext());
        if (r101 == null) goto L9;
        ContentResolver r102 = r101.getContentResolver();
    L10:
        if (r102 != null) goto L18;
        ALogger.e("LikeEggImagePickerDialog", "contentResolver is null");
        dismiss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L24;
        d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L24:
        return;
    L18:
        ImagePickViewModel r104 = this.f139951j;
        if (r104 == null) goto L26;
        r104.setMContentResolver(r102);
        return;
    L26:
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        setStyle(1, R.style.ttlive_like_egg_image_picker);
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        f.d().f();     // Catch: Throwable -> L5
        this.f139955n.dispose();     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        ImagePickViewModel r101 = this.f139951j;
        if (r101 == null) goto L10;
        ImageItemAdapter r102 = this.f139952k;
        if (r102 == null) goto L7;
        ArrayList<String> r103 = r102.f139935a;
    L8:
        r101.saveState(r100, r103);
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle r100) {
        super.onViewStateRestored(r100);
        if (r100 == null) goto L8;
        ImagePickViewModel r101 = this.f139951j;
        if (r101 == null) goto L9;
        r101.restoreState(r100);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker.LikeEggImagePickerDialog$initImageRecyclerView$4] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f139948g = (RecyclerView) r100.findViewById(R.id.image_recycler_view);
        this.f139949h = r100.findViewById(R.id.close);
        this.f139950i = r100.findViewById(R.id.dialog_root);
        View r102 = this.f139949h;
        if (r102 == null) goto L5;
        r102.setOnClickListener(new c(this));
    L5:
        S90();
        ImageItemAdapter r103 = new ImageItemAdapter();
        Function2<Integer, String, Unit> r104 = new LikeEggImagePickerDialog$initImageRecyclerView$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r104, "action");
        r103.f139936b = r104;
        Unit r105 = Unit.INSTANCE;
        this.f139952k = r103;
        RecyclerView r106 = this.f139948g;
        if (r106 == null) goto L8;
        r106.setLayoutManager(new GridLayoutManager(getContext(), 4));
    L8:
        RecyclerView r107 = this.f139948g;
        if (r107 == null) goto L11;
        r107.setHasFixedSize(true);
    L11:
        RecyclerView r108 = this.f139948g;
        if (r108 == null) goto L14;
        r108.addItemDecoration(new ImagePickerItemDecoration(UtilityKotlinExtentionsKt.i(2), UtilityKotlinExtentionsKt.i(2)));
    L14:
        ImageItemAdapter r109 = this.f139952k;
        if (r109 == null) goto L24;
        r109.f139935a.clear();
        ImagePickViewModel r110 = this.f139951j;
        if (r110 == null) goto L21;
        List<String> r111 = r110.getInitImagePaths();
        if (r111 == null) goto L21;
        r109.f139935a.addAll(r111);
    L21:
        RecyclerView r112 = this.f139948g;
        if (r112 == null) goto L24;
        r112.setAdapter(r109);
    L24:
        LikeEggImagePickerDialog$initImageRecyclerView$4 r113 = this.f139953l;
        if (r113 == null) goto L29;
        RecyclerView r114 = this.f139948g;
        if (r114 == null) goto L29;
        r114.removeOnScrollListener(r113);
    L29:
        ?? r115 = new LikeEggImagePickerDialog$initImageRecyclerView$4(this);
        this.f139953l = r115;
        RecyclerView r116 = this.f139948g;
        if (r116 == 0) goto L32;
        r116.addOnScrollListener(r115);
    L32:
        ImagePickViewModel r117 = this.f139951j;
        if (r117 == null) goto L38;
        MutableLiveData<ArrayList<String>> r118 = r117.getMImagePathsBuffer();
        if (r118 == null) goto L38;
        r118.observe(this, new b(this));
    L38:
        if (PadConfigUtils.c() == false) goto L48;
        u r119 = r.u(this.f139947f, null, 2);
        if (r119 == null) goto L48;
        n<PadOrientation> r120 = r119.w();
        if (r120 == null) goto L48;
        Observable<sh6.b<PadOrientation>> r121 = r120.a();
        if (r121 == null) goto L48;
        Disposable r122 = r121.subscribe(new a(this));
        if (r122 == null) goto L48;
        RxUtilKt.c(r122, this.f139955n);
    L48:
        int r123 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.f140046a;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_vs_photo_album_show", new LinkedHashMap());
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        f.d().a();
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.show(r100, r101);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void showNow(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        f.d().a();
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.showNow(r100, r101);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (PadConfigUtils.c() == false) goto L5;
        int r103 = R.layout.ttlive_like_egg_image_picker_dialog_pad;
    L7:
        return r100.inflate(r103, r101);
    L5:
        r103 = R.layout.ttlive_like_egg_image_picker_dialog;
        goto L7
    }
}
