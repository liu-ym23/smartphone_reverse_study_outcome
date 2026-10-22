package com.bytedance.android.gamecp.business.imagechoose;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import com.bytedance.android.gamecp.business.BaseGamePromoteDialogV2;
import com.bytedance.android.gamecp.common.ui.SpaceItemDecoration;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/imagechoose/ImageChooseDialog;", "Lcom/bytedance/android/gamecp/business/BaseGamePromoteDialogV2;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageChooseDialog extends BaseGamePromoteDialogV2 {
    public final int A;
    public LinkedList<w> B;
    public volatile boolean C;
    public volatile boolean D;
    public int E;
    public final Function1<LinkedList<w>, Unit> F;
    public final Function1<w, Unit> G;
    public final int H;
    public final ArrayList<w> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f56027J;
    public final Integer K;
    public final Function1<ArrayList<w>, Unit> L;
    public final JSONObject M;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f56028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView f56029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f56030o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f56031p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RecyclerView f56032q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f56033r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f56034s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f56035t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList<w> f56036u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ImageChooseAdapter f56037v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageChooseSummaryAdapter f56038w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bytedance.android.gamecp.common.ui.k f56039x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f56040y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f56041z;

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageChooseDialog f56042a;

        public c(ImageChooseDialog r100) {
            this.f56042a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ConstraintLayout r101 = this.f56042a.f56028m;
            if (r101 == null) goto L6;
            UtilityKotlinExtentionsKt.h(r101);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageChooseDialog f56043a;

        public d(ImageChooseDialog r100) {
            this.f56043a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ImageChooseDialog r101 = this.f56043a;
            if (r101.f56040y == false) goto L6;
            return;
        L6:
            if (r101.B != null) goto L8;
            return;
        L8:
            r101.L.invoke(new ArrayList(this.f56043a.B));
            ImageChooseDialog r102 = this.f56043a;
            if (r102.f56027J == false) goto L26;
            r102.f56040y = true;
            r102.f56039x = new com.bytedance.android.gamecp.common.ui.k(com.bytedance.android.gamecp.common.utils.g.a(this.f56043a.f51717k));
            com.bytedance.android.gamecp.common.ui.k r103 = this.f56043a.f56039x;
            if (r103 == null) goto L13;
            r103.f57016c = y0.i(R.string.ttlive_game_promote_image_uploading);
        L13:
            com.bytedance.android.gamecp.common.ui.k r104 = this.f56043a.f56039x;
            if (r104 == null) goto L16;
            r104.setCancelable(false);
        L16:
            com.bytedance.android.gamecp.common.ui.k r105 = this.f56043a.f56039x;
            if (r105 == null) goto L19;
            r105.setCanceledOnTouchOutside(false);
        L19:
            com.bytedance.android.gamecp.common.ui.k r106 = this.f56043a.f56039x;
            if (r106 != null) goto L22;
            return;
        L22:
            if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L47;
            DialogLancet.handleBlockedDialogShow(r106);
            return;
        L47:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
        L25:
            DialogLancet.beforeDialogShow(r106);
            r106.show();
            DialogLancet.afterDialogShow(r106);
            return;
        L26:
            Handler r107 = DialogLancet.resolveDialogHandler(r102);
            if (r107 != null) goto L29;
        L31:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L34 Exception -> L36
        L40:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L34:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L36:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L34
            Throwable r108 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L34
            if (r108 == null) goto L40;
            com.bytedance.crash.d.d(r108, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L34
            goto L40
        L29:
            if (Looper.myLooper() == r107.getLooper()) goto L31;
            r107.post(DialogLancet.createDismissRunnable(r102));
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageChooseDialog f56044a;

        public e(ImageChooseDialog r100) {
            this.f56044a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ImageChooseDialog r101 = this.f56044a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class f<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageChooseDialog f56045a;

        public f(ImageChooseDialog r100) {
            this.f56045a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<ArrayList<w>> r100) {
            Intrinsics.checkNotNullParameter(r100, "subscriber");
            this.f56045a.D = true;
            ImageChooseDialog r101 = this.f56045a;
            List r102 = ImageChooseDialog.R0(r101, r101.f51717k, r101.A, r101.f56041z);
            this.f56045a.f56036u.addAll(r102);
            r100.onNext(this.f56045a.f56036u);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageChooseDialog f56046a;

        public g(ImageChooseDialog r100) {
            this.f56046a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ArrayList r101 = (ArrayList) r100;
            int r102 = r101.size();
            ImageChooseDialog r103 = this.f56046a;
            if (r102 >= r103.A) goto L6;
            r103.C = true;
        L6:
            if (Build.VERSION.SDK_INT >= 34) goto L8;
        L12:
            ImageChooseAdapter r104 = this.f56046a.f56037v;
            if (r104 == null) goto L15;
            Intrinsics.checkNotNullParameter(r101, "mediaTotal");
            r104.f56008b.clear();
            r104.f56008b.addAll(r101);
            r104.notifyDataSetChanged();
        L15:
            this.f56046a.D = false;
            return;
        L8:
            if (ru.c.c(this.f56046a.getContext(), new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"}) == true) goto L12;
            if (ru.c.c(this.f56046a.getContext(), new String[]{"android.permission.READ_MEDIA_VISUAL_USER_SELECTED"}) == false) goto L12;
            r101.add(new w(-1));
            goto L12
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageChooseDialog f56047a;

        public h(ImageChooseDialog r100) {
            this.f56047a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            b r101 = (b) r100;
            com.bytedance.android.gamecp.common.ui.k r102 = this.f56047a.f56039x;
            if (r102 == null) goto L21;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r102);
            goto L21
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r104 == null) goto L18;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L7:
            if (Looper.myLooper() == r103.getLooper()) goto L9;
            r103.post(DialogLancet.createDismissRunnable(r102));
        L21:
            ImageChooseDialog r105 = this.f56047a;
            r105.f56040y = false;
            Handler r106 = DialogLancet.resolveDialogHandler(r105);
            if (r106 != null) goto L24;
        L26:
            DialogLancet.beforeDialogDismiss(r105);
            r105.dismiss();     // Catch: Throwable -> L29 Exception -> L31
        L35:
            DialogLancet.afterDialogDismiss(r105);
            return;
        L29:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r105);
            throw th;
        L31:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L29
            Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L29
            if (r107 == null) goto L35;
            com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L29
            goto L35
        L24:
            if (Looper.myLooper() == r106.getLooper()) goto L26;
            r106.post(DialogLancet.createDismissRunnable(r105));
        }
    }

    static {
    }

    public ImageChooseDialog() {
        throw null;
    }

    @Override // com.bytedance.android.gamecp.business.BaseGamePromoteDialogV2
    public final int[] M0() {
        return new int[]{-1, -1, -1, -1};
    }

    @Override // com.bytedance.android.gamecp.business.BaseGamePromoteDialogV2
    public final int getLayoutId() {
        return R.layout.gamecp_game_promote_image_choose;
    }

    public final void T0() {
        Disposable r100 = Observable.create(new f(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this));
        this.f51708b.add(r100);
    }

    @Override // com.bytedance.android.gamecp.business.BaseGamePromoteDialogV2
    public final void initView() {
        String r100 = "";
        this.f56029n = (RecyclerView) findViewById(R.id.rv_game_comment_choose_images);
        this.f56030o = (ImageView) findViewById(R.id.iv_cancel);
        this.f56031p = (TextView) findViewById(R.id.tv_confirm);
        this.f56032q = (RecyclerView) findViewById(R.id.rv_images_summary);
        this.f56034s = findViewById(R.id.images_summary);
        this.f56035t = (TextView) findViewById(R.id.tv_select_description);
        this.f56028m = (ConstraintLayout) findViewById(R.id.cl_image_viewer);
        ImageView r101 = (ImageView) findViewById(R.id.iv_cancel_viewer);
        if (r101 == null) goto L5;
        r101.setOnClickListener(new c(this));
    L5:
        TextView r102 = this.f56035t;
        boolean r103 = true;
        if (r102 == null) goto L8;
        r102.setText(y0.j(R.string.ttlive_game_promote_select_image_maximum_summary_tip, new Object[]{Integer.valueOf(this.H)}));
    L8:
        TextView r104 = this.f56031p;
        if (r104 == null) goto L11;
        r104.setOnClickListener(new d(this));
    L11:
        ImageView r105 = this.f56030o;
        if (r105 == null) goto L14;
        r105.setOnClickListener(new e(this));
    L14:
        JSONObject r106 = this.M;
        if (r106 != null) goto L90;
    L37:
        RecyclerView r107 = this.f56029n;
        RecyclerView.ItemAnimator r108 = null;
        if (r107 == null) goto L40;
        r107.setLayoutManager(new GridLayoutManager(null, 4));
    L40:
        RecyclerView r109 = this.f56029n;
        if (r109 == null) goto L43;
        r109.addItemDecoration(new GridSpacingItemDecoration(4, UtilityKotlinExtentionsKt.c(2)));
    L43:
        RecyclerView r110 = this.f56029n;
        if (r110 == null) goto L46;
        r110.addOnScrollListener(new AnonymousClass4(this));
    L46:
        RecyclerView r111 = this.f56029n;
        if (r111 == null) goto L92;
        r111.setItemViewCacheSize(8);
    L92:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L57
        JSONObject r113 = this.M;     // Catch: Throwable -> L57
        if (r113 == null) goto L55;
        String r114 = JSONObjectProtectorUtils.getString(r113, "limit_tips");     // Catch: Throwable -> L57
        if (r114 == null) goto L55;
        r100 = r114;
    L55:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L59:
        ImageChooseAdapter r115 = new ImageChooseAdapter(this.f51717k, this.H, this.I, this.K, r100, new AnonymousClass6(this));
        this.f56037v = r115;
        Function0<Unit> r116 = new AnonymousClass7(this);
        Intrinsics.checkNotNullParameter(r116, SendEventContainerMethodParamModel.EventKinds.onClick);
        r115.f56016j = r116;
        RecyclerView r117 = this.f56029n;
        if (r117 == null) goto L62;
        r117.setAdapter(this.f56037v);
    L62:
        RecyclerView r118 = this.f56029n;
        if (r118 == null) goto L65;
        RecyclerView.ItemAnimator r119 = r118.getItemAnimator();
    L67:
        if ((r119 instanceof SimpleItemAnimator) == false) goto L70;
        r108 = r119;
    L70:
        SimpleItemAnimator r120 = (SimpleItemAnimator) r108;
        if (r120 == null) goto L73;
        r120.setSupportsChangeAnimations(false);
    L73:
        ImageChooseAdapter r121 = this.f56037v;
        if (r121 == null) goto L76;
        Function1<LinkedList<w>, Unit> r122 = this.F;
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        r121.f56015i = r122;
    L76:
        RecyclerView r123 = this.f56032q;
        if (r123 == null) goto L79;
        r123.setLayoutManager(new LinearLayoutManager(this.f51717k, 0, false));
    L79:
        ImageChooseSummaryAdapter r124 = new ImageChooseSummaryAdapter(this.f51717k);
        this.f56038w = r124;
        RecyclerView r125 = this.f56032q;
        if (r125 == null) goto L82;
        r125.setAdapter(r124);
    L82:
        RecyclerView r126 = this.f56032q;
        if (r126 == null) goto L85;
        r126.addItemDecoration(new SpaceItemDecoration(UtilityKotlinExtentionsKt.c(16)));
    L85:
        ImageChooseSummaryAdapter r127 = this.f56038w;
        if (r127 == null) goto L88;
        Function1<w, Unit> r128 = this.G;
        Intrinsics.checkNotNullParameter(r128, "<set-?>");
        r127.f56055c = r128;
    L88:
        T0();
        return;
    L65:
        r119 = null;
    L57:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L59
    L90:
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L35
        String r131 = JSONObjectProtectorUtils.getString(r106, "bottom_view_title");     // Catch: Throwable -> L35
        if (r131.length() <= 0) goto L20;
        boolean r132 = true;
    L21:
        if (r132 == false) goto L25;
        TextView r133 = this.f56035t;     // Catch: Throwable -> L35
        if (r133 == null) goto L25;
        r133.setText(r131);     // Catch: Throwable -> L35
    L25:
        String r134 = JSONObjectProtectorUtils.getString(this.M, "next_button_text");     // Catch: Throwable -> L35
        if (r134.length() > 0) goto L29;
        r103 = false;
    L29:
        if (r103 == false) goto L33;
        TextView r135 = this.f56031p;     // Catch: Throwable -> L35
        if (r135 == null) goto L33;
        r135.setText(r134);     // Catch: Throwable -> L35
    L33:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
        goto L37
    L20:
        r132 = false;
    L35:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    @Override // com.bytedance.android.gamecp.business.BaseGamePromoteDialogV2
    public final Integer L0() {
        return Integer.valueOf(R.drawable.shape_bg_ffffff_top_corner_12);
    }

    @Override // com.bytedance.android.gamecp.business.BaseGamePromoteDialogV2, com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        Disposable r100 = jv.a.a().c(b.class).subscribe(new h(this));
        if (r100 == null) goto L5;
        this.f51708b.add(r100);
    L5:
        DialogLancet.handleDialogPreAddViewOnStart(this, "bottomSheetDialog:onStart");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r100 != 4) goto L14;
        ConstraintLayout r102 = this.f56028m;
        if (r102 == null) goto L14;
        if (r102.getVisibility() != 0) goto L14;
        ConstraintLayout r103 = this.f56028m;
        if (r103 == null) goto L15;
        r103.setVisibility(8);
        return true;
    L15:
        return true;
    L14:
        return super.onKeyDown(r100, r101);
    }

    public static List S0(Context r210, String r211, String[] r212) {
        ArrayList r100 = new ArrayList();
        String[] r101 = {DBDefinition.ID, "_data", "date_modified", "mime_type", "_size", "latitude", "longitude", "_data", "date_modified", "orientation", "width", "height", "datetaken"};
        int r102 = 0;
        Cursor r103 = null;
        r103 = Q0(r210.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r101, r211, r212);     // Catch: Throwable -> L24
        if (r103 != null) goto L34;
        return r100;
    L34:
    L22:
        th = th;
        ArrayList r104 = r100;
    L36:
        x8.a.c("Error", th, false);     // Catch: Throwable -> L30
        if (r103 == null) goto L29;
    L28:
        r103.close();
    L29:
        return r104;
    L30:
        th = move-exception;
        if (r103 == null) goto L33;
        r103.close();
    L33:
        throw th;
    L7:
        if (r103.moveToNext() == false) goto L21;
        long r105 = r103.getLong(r102);     // Catch: Throwable -> L22
        String r106 = r103.getString(1);     // Catch: Throwable -> L22
        long r107 = r103.getLong(2);     // Catch: Throwable -> L22
        r103.getString(3);     // Catch: Throwable -> L22
        long r108 = r103.getLong(4);     // Catch: Throwable -> L22
        double r110 = r103.getDouble(5);     // Catch: Throwable -> L22
        double r111 = r103.getDouble(6);     // Catch: Throwable -> L22
        String r109 = r103.getString(7);     // Catch: Throwable -> L22
        Cursor r213 = r103;
        long r112 = r103.getInt(8);     // Catch: Throwable -> L22
        ArrayList r113 = r100;
        int r114 = r213.getInt(9);     // Catch: Throwable -> L19
        int r115 = r213.getInt(10);     // Catch: Throwable -> L19
        int r116 = r213.getInt(11);     // Catch: Throwable -> L19
        long r117 = r213.getLong(12);     // Catch: Throwable -> L19
        if (r108 > 0) goto L13;
        r104 = r113;
    L16:
        r103 = r213;
        r100 = r104;
        r102 = 0;
        goto L34
    L13:
        w r118 = new w(r105);     // Catch: Throwable -> L19
        r118.f51415e = r106;     // Catch: Throwable -> L19
        r118.f51416f = r106;     // Catch: Throwable -> L19
        r118.f51418h = r106;     // Catch: Throwable -> L19
        r118.f51420j = r107;     // Catch: Throwable -> L19
        r118.f51423m = r108;     // Catch: Throwable -> L19
        r118.f51425o = r109;     // Catch: Throwable -> L19
        r118.f51428r = r110;     // Catch: Throwable -> L19
        r118.f51429s = r111;     // Catch: Throwable -> L19
        r118.f51430t = r112;     // Catch: Throwable -> L19
        r118.f51431u = r114;     // Catch: Throwable -> L19
        r118.f51432v = r117;     // Catch: Throwable -> L19
        r118.f51426p = r115;     // Catch: Throwable -> L19
        r118.f51427q = r116;     // Catch: Throwable -> L19
        r104 = r113;
        r104.add(r118);     // Catch: Throwable -> L17
    L17:
        th = th;
    L18:
        r103 = r213;
    L19:
        th = th;
        r104 = r113;
        goto L18
    L21:
        r104 = r100;
    L24:
        th = th;
        r104 = r100;
        goto L36
    }

    public static List R0(ImageChooseDialog r100, Context r101, int r102, int r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r104 = "date_modified ".concat("DESC");
        String r105 = " LIMIT " + r102 + " OFFSET " + (r103 * r102);
        ArrayList r106 = new ArrayList();
        String[] r107 = null;
        if (TextUtils.isEmpty(null) == true) goto L5;
        r106.add("%null%");
        String r108 = "_data like ?";
    L6:
        new ArrayList();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        if (r108 != null) goto L9;
    L12:
        boolean r109 = true;
    L13:
        String r110 = "mime_type not like ?";
        if (r109 == true) goto L23;
        if (r108 == null) goto L22;
        Intrinsics.checkNotNullParameter(r108, "$this$appendSelection");
        Intrinsics.checkNotNullParameter("mime_type not like ?", "toBeAppend");
        StringBuilder r111 = new StringBuilder();
        r111.append(r108);
        if (TextUtils.isEmpty(r108) == true) goto L21;
        r110 = " AND ".concat("mime_type not like ?");
    L21:
        r111.append(r110);
        r110 = r111.toString();
        goto L23
    L22:
        r110 = null;
    L23:
        r106.add("%gif%");
        if (r106.size() <= 0) goto L30;
        Object[] r112 = r106.toArray(new String[0]);
        if (r112 == null) goto L29;
        r107 = (String[]) r112;
        goto L30
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L30:
        if (r102 > 0) goto L33;
        return S0(r101, r110, r107);
    L33:
        return S0(r101, r110, r107);
    L9:
        if (r108.length() == 0) goto L12;
        r109 = false;
        goto L13
    L5:
        r108 = null;
        goto L6
    }

    public static Cursor Q0(ContentResolver r110, Uri r111, String[] r112, String r210, String[] r211) {
        f06.c r113 = new f06.c();
        Object[] r114 = {r111, r112, r210, r211, "_id DESC"};
        f06.b r115 = new f06.b();
        f06.d r100 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
        if (r100.f474982a == false) goto L6;
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, r210, r211, "_id DESC");
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r101, r115, true);
        return r101;
    }

    public ImageChooseDialog(Context r100, int r101, ArrayList r102, boolean r103, Integer r104, Function1 r105, JSONObject r106, int r110) {
        if ((r110 & 16) == 0) goto L6;
        r103 = false;
    L6:
        if ((r110 & 32) == 0) goto L9;
        r104 = null;
    L9:
        if ((r110 & 128) == 0) goto L11;
        r106 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r105, "onResult");
        super(r100, r104);
        this.H = r101;
        this.I = r102;
        this.f56027J = r103;
        this.K = r104;
        this.L = r105;
        this.M = r106;
        this.f56036u = new ArrayList();
        this.A = 100;
        this.F = new ImageChooseDialog$onImageChooseListener$1(this);
        this.G = new ImageChooseDialog$onImageSummaryCancelListener$1(this);
    }
}
