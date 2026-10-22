package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.HighlightPreviewDialog;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class MarkHighlightController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f135678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f135679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f135680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f135681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f135682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f135683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HSImageView f135684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f135685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LiveDoubleColorBallAnimationView f135686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f135687l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HighlightViewAdapter f135688m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f135689n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Disposable f135690o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CompositeDisposable f135691p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HighlightPreviewDialog f135692q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<com.bytedance.android.livesdk.interactivity.comment.highlight.b> f135693r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f135694s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<String> f135695t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f135696u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f135697v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f135698w;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController$HighlightViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController$HighlightViewAdapter$HighlightPreviewViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController;", "HighlightPreviewViewHolder", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class HighlightViewAdapter extends RecyclerView.Adapter<HighlightPreviewViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f135699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.bytedance.android.livesdk.interactivity.comment.highlight.b> f135700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MarkHighlightController f135701c;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController$HighlightViewAdapter$HighlightPreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public final class HighlightPreviewViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final HSImageView f135702a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TextView f135703b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ImageView f135704c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final RelativeLayout f135705d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final float f135706e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final float f135707f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ HighlightViewAdapter f135708g;

            public static final class a implements View.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ HighlightPreviewViewHolder f135709a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Function0 f135710b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Function1 f135711c;

                public a(HighlightPreviewViewHolder r100, Function0 r101, Function1 r102) {
                    this.f135709a = r100;
                    this.f135710b = r101;
                    this.f135711c = r102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View r100) {
                    if (((Boolean) this.f135710b.invoke()).booleanValue() == false) goto L5;
                    return;
                L5:
                    this.f135711c.invoke(Integer.valueOf(this.f135709a.getAdapterPosition()));
                }
            }

            public static final class b implements View.OnClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ HighlightPreviewViewHolder f135712a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Function0 f135713b;

                public b(HighlightPreviewViewHolder r100, Function0 r101) {
                    this.f135712a = r100;
                    this.f135713b = r101;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View r100) {
                    if (((Boolean) this.f135713b.invoke()).booleanValue() == false) goto L5;
                    return;
                L5:
                    int r101 = this.f135712a.getAdapterPosition();
                    HighlightViewAdapter r102 = this.f135712a.f135708g;
                    int r103 = r102.f135699a;
                    r102.f135699a = r101;
                    Bundle r104 = new Bundle();
                    r104.putBoolean("SELECTED", true);
                    Unit r105 = Unit.INSTANCE;
                    r102.notifyItemChanged(r101, r104);
                    if (r103 == (-1)) goto L9;
                    HighlightViewAdapter r106 = this.f135712a.f135708g;
                    Bundle r107 = new Bundle();
                    r107.putBoolean("SELECTED", false);
                    r106.notifyItemChanged(r103, r107);
                    return;
                }
            }

            public HighlightPreviewViewHolder(HighlightViewAdapter r100, View r101, CompositeDisposable r102, Function0<Boolean> r103, Function1<? super Integer, Unit> r104) {
                Intrinsics.checkNotNullParameter(r101, "itemView");
                Intrinsics.checkNotNullParameter(r102, "dispose");
                Intrinsics.checkNotNullParameter(r103, "blockAction");
                Intrinsics.checkNotNullParameter(r104, "previewAction");
                this.f135708g = r100;
                super(r101);
                HSImageView r105 = (HSImageView) r101.findViewById(R.id.preview_pic);
                this.f135702a = r105;
                this.f135703b = (TextView) r101.findViewById(R.id.main_title);
                this.f135704c = (ImageView) r101.findViewById(R.id.highlight_check);
                RelativeLayout r106 = (RelativeLayout) r101.findViewById(R.id.bottom_container);
                this.f135705d = r106;
                this.f135706e = 1.33f;
                this.f135707f = 0.67f;
                r105.setOnClickListener(new a(this, r103, r104));
                r106.setOnClickListener(new b(this, r103));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f135700b).size();
        }

        public HighlightViewAdapter(MarkHighlightController r100) {
            this.f135701c = r100;
            this.f135700b = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            HighlightPreviewViewHolder r102 = (HighlightPreviewViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "vh");
            com.bytedance.android.livesdk.interactivity.comment.highlight.b r103 = (com.bytedance.android.livesdk.interactivity.comment.highlight.b) ListProtector.get(this.f135700b, r101);
            if (r101 != this.f135699a) goto L5;
            boolean r104 = true;
        L6:
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "data");
            Ref.FloatRef r105 = new Ref.FloatRef();
            r105.element = r102.f135707f;
            IInteractivityInjectService r106 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r106 == null) goto L13;
            ILivePlayerClient r107 = r106.currentClient();
            if (r107 == null) goto L13;
            IRenderView r108 = r107.getRenderView();
            if (r108 == null) goto L13;
            int r109 = r108.getWidth();
        L14:
            IInteractivityInjectService r110 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r110 == null) goto L21;
            ILivePlayerClient r111 = r110.currentClient();
            if (r111 == null) goto L21;
            IRenderView r112 = r111.getRenderView();
            if (r112 == null) goto L21;
            int r113 = r112.getHeight();
        L22:
            if (r109 <= 0) goto L28;
            if (r113 <= 0) goto L28;
            if (r109 < r113) goto L26;
            float r114 = r102.f135706e;
        L27:
            r105.element = r114;
            goto L28
        L26:
            r114 = r102.f135707f;
        L28:
            r102.f135702a.post(new q0(r102, r105));
            ImageUtil.loadImage(r102.f135702a, r103.c(), 0);
            r102.f135703b.setText(r103.h());
            if (r104 == false) goto L31;
            r102.f135704c.setBackgroundResource(R.drawable.ttlive_mark_highlight_video_checked);
            return;
        L31:
            r102.f135704c.setBackgroundResource(R.drawable.ttlive_mark_highlight_video_unchecked);
            return;
        L21:
            r113 = 0;
        L13:
            r109 = 0;
            goto L14
        L5:
            r104 = false;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r110) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new HighlightPreviewViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_input_highlight_item, r100, false), this.f135701c.f135691p, new MarkHighlightController$HighlightViewAdapter$onCreateViewHolder$1(this), new MarkHighlightController$HighlightViewAdapter$onCreateViewHolder$2(this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
            HighlightPreviewViewHolder r103 = (HighlightPreviewViewHolder) r100;
            Intrinsics.checkNotNullParameter(r103, "holder");
            Intrinsics.checkNotNullParameter(r102, "payloads");
            if (r102.isEmpty() == false) goto L5;
            super.onBindViewHolder(r103, r101, r102);
            return;
        L5:
            Object r104 = ListProtector.get(r102, 0);
            if (r104 == null) goto L24;
            Bundle r105 = (Bundle) r104;
            Iterator<T> r106 = r105.keySet().iterator();
        L9:
            if (r106.hasNext() == false) goto L37;
            String r107 = (String) r106.next();
            if (r107 == null) goto L9;
            if (r107.hashCode() != 1974198939) goto L9;
            if (r107.equals("SELECTED") == false) goto L9;
            if (r105.getBoolean(r107) == true) goto L20;
            r103.f135704c.setBackgroundResource(R.drawable.ttlive_mark_highlight_video_unchecked);
            goto L9
        L20:
            r103.f135704c.setBackgroundResource(R.drawable.ttlive_mark_highlight_video_checked);
            goto L9
        L37:
            return;
        L24:
            throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/MarkHighlightController$SpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f135714a;

        public SpaceItemDecoration(int r100) {
            this.f135714a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            int r104 = r102.getChildAdapterPosition(r101);
            int r105 = r103.getItemCount();
            if (r104 != 0) goto L5;
            r100.left = UtilityKotlinExtentionsKt.i(16);
        L7:
            if (r104 != (r105 - 1)) goto L10;
            r100.right = UtilityKotlinExtentionsKt.i(16);
            return;
        L10:
            return;
        L5:
            r100.left = this.f135714a;
            goto L7
        }
    }

    public interface a {
        void onDismiss();

        void onShow();
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MarkHighlightController f135715a;

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MarkHighlightController.a
        public final void onDismiss() {
            MarkHighlightController.g(this.f135715a, false);
            this.f135715a.f135692q = null;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MarkHighlightController.a
        public final void onShow() {
            MarkHighlightController.g(this.f135715a, true);
        }

        public b(MarkHighlightController r100) {
            this.f135715a = r100;
        }
    }

    public final IBaseUser h() {
        IRoomContextService r100 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r100 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.o r101 = IRoomContextService.a.a(r100, this.f135513b.R(), 0, 2);
        if (r101 == null) goto L11;
        com.bytedance.live.datacontext.m<IRoom> r102 = r101.getRoom();
        if (r102 == null) goto L11;
        IRoom r103 = r102.getValue();
        if (r103 == null) goto L11;
        return r103.getOwner();
    L11:
        return null;
    }

    public final String i() {
        IBaseUser r100 = h();
        if (r100 == null) goto L6;
        String r101 = r100.getUserId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final void j(boolean r110) {
        if (r110 == false) goto L11;
        UtilityKotlinExtentionsKt.w(this.f135684i);
        this.f135687l.setClickable(false);
        View r111 = this.f135685j;
        if (r111 == null) goto L7;
        r111.setClickable(false);
    L7:
        LiveScreenRecordGuideConfig.a r112 = LiveScreenRecordGuideConfig.f99094c;
        DataCenter r100 = this.f135513b.R();
        r112.getClass();
        if (LiveScreenRecordGuideConfig.a.a(r100) == true) goto L10;
        UtilityKotlinExtentionsKt.u(this.f135687l);
    L10:
        RotateAnimation r113 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r113.setRepeatCount(-1);
        r113.setDuration(400);
        Unit r101 = Unit.INSTANCE;
        this.f135684i.startAnimation(r113);
        this.f135694s = true;
        return;
    L11:
        this.f135684i.clearAnimation();
        UtilityKotlinExtentionsKt.t(this.f135684i);
        this.f135687l.setClickable(true);
        View r114 = this.f135685j;
        if (r114 == null) goto L14;
        r114.setClickable(true);
    L14:
        UtilityKotlinExtentionsKt.w(this.f135687l);
        this.f135694s = false;
    }

    public final void k(int r100) {
        if (r100 != 0) goto L5;
        UtilityKotlinExtentionsKt.w(this.f135680e);
        UtilityKotlinExtentionsKt.t(this.f135681f);
        this.f135686k.c();
        UtilityKotlinExtentionsKt.t(this.f135682g);
        UtilityKotlinExtentionsKt.w(this.f135683h);
        return;
    L5:
        if (r100 != this.f135678c) goto L7;
        UtilityKotlinExtentionsKt.t(this.f135680e);
        UtilityKotlinExtentionsKt.t(this.f135681f);
        UtilityKotlinExtentionsKt.w(this.f135682g);
        this.f135686k.b();
        UtilityKotlinExtentionsKt.t(this.f135683h);
        return;
    L7:
        UtilityKotlinExtentionsKt.t(this.f135680e);
        UtilityKotlinExtentionsKt.w(this.f135681f);
        this.f135686k.c();
        UtilityKotlinExtentionsKt.t(this.f135682g);
        UtilityKotlinExtentionsKt.t(this.f135683h);
    }

    public MarkHighlightController(View r100, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "panelBridge");
        super(r100, r101);
        this.f135698w = r101;
        this.f135678c = 1;
        this.f135679d = 2;
        r101.R();
        ViewStub r102 = (ViewStub) r100.findViewById(R.id.hint_container);
        LiveScreenRecordGuideConfig.a r103 = LiveScreenRecordGuideConfig.f99094c;
        DataCenter r104 = this.f135513b.R();
        r103.getClass();
        if (LiveScreenRecordGuideConfig.a.a(r104) == false) goto L5;
        int r105 = R.layout.ttlive_view_stub_mark_highlight_publish_new;
    L6:
        r102.setLayoutResource(r105);
        r102.inflate();
        this.f135680e = (RecyclerView) r100.findViewById(R.id.highlight_preview_list);
        this.f135681f = (LinearLayout) r100.findViewById(R.id.no_res_layout);
        this.f135682g = (LinearLayout) r100.findViewById(R.id.loading_layout);
        this.f135683h = (LinearLayout) r100.findViewById(R.id.operateLayout);
        this.f135684i = (HSImageView) r100.findViewById(R.id.publish_loading);
        this.f135685j = r100.findViewById(R.id.llRecord);
        this.f135686k = (LiveDoubleColorBallAnimationView) r100.findViewById(R.id.loading_ball);
        this.f135687l = r100.findViewById(R.id.go_publish);
        this.f135688m = new HighlightViewAdapter(this);
        this.f135691p = new CompositeDisposable();
        this.f135695t = new ArrayList();
        this.f135696u = new b(this);
        int r106 = e72.c.f471166a;
        this.f135697v = e72.c.c(r101.getContext());
        return;
    L5:
        r105 = R.layout.ttlive_view_stub_mark_highlight_publish;
        goto L6
    }

    public static final void g(MarkHighlightController r100, boolean r101) {
        r100.getClass();
        if (r101 == false) goto L7;
        IInteractivityInjectService r102 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r102 == null) goto L11;
        r102.muteLivePlayerClient();
    L11:
        if (v22.a.f552666b.booleanValue() == true) goto L13;
        return;
    L13:
        if (hd0.c.f().h() == true) goto L15;
        return;
    L15:
        if (r101 == false) goto L21;
        IPushStreamService r103 = (IPushStreamService) jc1.k.f(IPushStreamService.class);
        if (r103 == null) goto L29;
        com.bytedance.android.live.pushstream.d r104 = r103.getPushLiveStream();
        if (r104 == null) goto L30;
        r104.J0(LiveCommonConstants.REASON_HIGHLIGHT_PREVIEW, new uv0.a(LiveRequestSourceRole.Business, "MarkHighlightController.mutePlayerClient", null));
        return;
    L30:
        return;
    L29:
        return;
    L21:
        IPushStreamService r105 = (IPushStreamService) jc1.k.f(IPushStreamService.class);
        if (r105 == null) goto L32;
        com.bytedance.android.live.pushstream.d r106 = r105.getPushLiveStream();
        if (r106 == null) goto L33;
        r106.q1(LiveCommonConstants.REASON_HIGHLIGHT_PREVIEW, new uv0.a(LiveRequestSourceRole.Business, "MarkHighlightController.mutePlayerClient", null));
        return;
    L33:
        return;
    L32:
        return;
    L7:
        IInteractivityInjectService r107 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r107 == null) goto L11;
        r107.unmuteLivePlayerClient();
        goto L11
    }
}
