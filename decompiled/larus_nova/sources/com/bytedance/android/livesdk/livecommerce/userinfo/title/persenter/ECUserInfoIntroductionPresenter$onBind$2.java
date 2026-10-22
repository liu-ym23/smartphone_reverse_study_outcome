package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.widget.VerticalDashLineView;
import com.bytedance.android.ec.live.api.commerce.userinfo.ECAuthorArea;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.state.ECUserInfoState;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionLayout;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionRotationView;
import com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionRotationView$bindData$1;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$d;", "state", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/userinfo/title/state/ECUserInfoState$d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECUserInfoIntroductionPresenter$onBind$2 extends Lambda implements Function1<ECUserInfoState.d, Unit> {
    final /* synthetic */ c this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter.ECUserInfoIntroductionPresenter$onBind$2$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ ECIntroductionLayout $introductionLayout;

        public AnonymousClass1(ECIntroductionLayout r100) {
            this.$introductionLayout = r100;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$introductionLayout.setVisibility(4);
            dm.a.a("ECUserInfoIntroductionPresenter").i("introductionList is null");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter.ECUserInfoIntroductionPresenter$onBind$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lcom/bytedance/android/ec/live/api/commerce/userinfo/ECAuthorArea$e;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends ECAuthorArea.e>, Unit> {
        final /* synthetic */ ECIntroductionLayout $introductionLayout;

        public AnonymousClass2(ECIntroductionLayout r100) {
            this.$introductionLayout = r100;
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.view.ViewGroup, androidx.appcompat.widget.LinearLayoutCompat, com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionLayout, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v19, types: [com.bytedance.android.livesdk.livecommerce.userinfo.title.views.ECIntroductionRotationView$bindData$1] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v19 */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v5, types: [android.widget.TextView] */
        /* JADX WARN: Type inference failed for: r6v7 */
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
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ECAuthorArea.e> r210) {
            Intrinsics.checkNotNullParameter(r210, "$receiver");
            ?? r100 = this.$introductionLayout;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r210, "introductionList");
            r100.removeAllViews();
            Iterator r101 = r210.iterator();
        L3:
            boolean r102 = false;
            if (r101.hasNext() == false) goto L151;
            ECAuthorArea.e r103 = (ECAuthorArea.e) r101.next();
            ECAuthorArea.IntroductionDataType r104 = r103.getType();
            ?? r105 = 0;
            String r106 = null;
            r105 = 0;
            Integer r107 = null;
            r105 = 0;
            r105 = 0;
            r105 = 0;
            r105 = 0;
            r105 = 0;
            Integer r108 = null;
            r105 = 0;
            if (r104 == null) goto L140;
            int r109 = com.bytedance.android.livesdk.livecommerce.userinfo.title.views.a.f153025a[r104.ordinal()];
            boolean r110 = true;
            int r111 = 2;
            if (r109 == 1) goto L86;
            int r112 = -1;
            if (r109 == 2) goto L22;
            if (r109 != 3) goto L140;
            VerticalDashLineView r113 = (VerticalDashLineView) r100.d(r100.f153012d);
            VerticalDashLineView r114 = r113;
            if (r113 != null) goto L17;
            VerticalDashLineView r115 = new VerticalDashLineView(r100.getContext(), null, 6, 0);
            LinearLayoutCompat.LayoutParams r116 = new LinearLayoutCompat.LayoutParams(UtilityKotlinExtentionsKt.d(1), -1);
            r116.setMargins(0, UtilityKotlinExtentionsKt.d(2), 0, UtilityKotlinExtentionsKt.d(2));
            Unit r117 = Unit.INSTANCE;
            r115.setLayoutParams(r116);
            r115.a(UtilityKotlinExtentionsKt.c(1), 0.0f, 0.0f, 0.0f);
            r114 = r115;
        L17:
            int r118 = s.f45717a;
            ECAuthorArea.f r119 = r103.c();
            if (r119 == null) goto L20;
            r106 = r119.a();
        L20:
            r114.setDashLineColor(s.a(r106, th.a.a(r100.getContext(), R.color.shopping_color_4DFFFFFF)));
            Object r120 = r114;
        L21:
            r105 = r120;
            goto L140
        L22:
            ECAuthorArea.c r121 = r103.a();
            if (r121 == null) goto L140;
            List<ECAuthorArea.d> r122 = r121.a();
            final long r123 = r121.b();
            if (r122 == null) goto L140;
            ArrayList r124 = new ArrayList();
            Iterator r125 = r122.iterator();
        L29:
            if (r125.hasNext() == false) goto L37;
            Object r126 = r125.next();
            if (((ECAuthorArea.d) r126) == null) goto L33;
            boolean r127 = true;
        L34:
            if (r127 == false) goto L29;
            r124.add(r126);
            goto L29
        L33:
            r127 = false;
            goto L34
        L37:
            if ((!r124.isEmpty()) == false) goto L39;
            final ArrayList r128 = r124;
        L40:
            if (r128 == null) goto L140;
            if (r128.size() != 1) goto L45;
        L74:
            ECAuthorArea.d r129 = (ECAuthorArea.d) CollectionsKt.firstOrNull(r128);
            if (r129 == null) goto L140;
            if (r129.a() == null) goto L140;
            TextView r130 = (TextView) r100.d(r100.f153011c);
            if (r130 != null) goto L82;
            int r131 = ECIntroductionLayout.f153010g;
            r130 = ECIntroductionLayout.a.a(r100.getContext());
        L82:
            r105 = r130;
            String r132 = r129.a();
            if (r132 != null) goto L85;
            r132 = "";
        L85:
            r105.setText(r132);
            r105.requestLayout();
            int r133 = s.f45717a;
            r105.setTextColor(s.a(r129.b(), th.a.a(r100.getContext(), R.color.shopping_color_CCFFFFFF)));
            goto L140
        L45:
            if (r123 < 0) goto L74;
            ECIntroductionRotationView r134 = (ECIntroductionRotationView) r100.d(r100.f153014f);
            if (r134 != null) goto L50;
            r134 = new ECIntroductionRotationView(r100.getContext());
            r100.setGravity(8388627);
        L50:
            Intrinsics.checkNotNullParameter(r128, "dataList");
            ECIntroductionRotationView$bindData$1 r135 = r134.f153015a;
            if (r135 == null) goto L53;
            r135.a();
        L53:
            r134.f153015a = null;
            r134.f153018d = -1;
            Iterator r136 = r128.iterator();
            int r137 = 0;
        L55:
            if (r136.hasNext() == false) goto L62;
            String r138 = ((ECAuthorArea.d) r136.next()).a();
            if (r138 == null) goto L55;
            int r139 = (int) ((r134.f153016b.getPaint().measureText(r138) + r134.f153016b.getCompoundPaddingLeft()) + r134.f153016b.getCompoundPaddingRight());
            if (r139 <= r137) goto L55;
            r137 = r139;
            goto L55
        L62:
            Integer r140 = Integer.valueOf(r137);
            if (r140.intValue() > 0) goto L66;
            r110 = false;
        L66:
            if (r110 == false) goto L68;
            r107 = r140;
        L68:
            if (r107 == null) goto L70;
            r112 = r107.intValue();
        L70:
            r134.f153018d = r112;
            final ECIntroductionRotationView r141 = r134;
            final ArrayList r142 = r128;
            r134.f153015a = new ECIntroductionRotationView$bindData$1(r141, r142, r128, r123, r123);
            r134.f153016b.setVisibility(0);
            ECIntroductionRotationView$bindData$1 r143 = r134.f153015a;
            if (r143 == null) goto L73;
            r143.j();
        L73:
            r105 = r134;
            goto L140
        L39:
            r128 = null;
            goto L40
        L86:
            ECUrlModel r144 = r103.b();
            if (r144 == null) goto L140;
            ECDraweeView r145 = (ECDraweeView) r100.d(r100.f153013e);
            ECDraweeView r146 = r145;
            if (r145 != null) goto L92;
            r146 = new ECDraweeView(r100.getContext(), null, 0, 6, null);
        L92:
            Integer r147 = Integer.valueOf(r144.getWidth());
            if (r147.intValue() <= 0) goto L95;
            boolean r148 = true;
        L96:
            if (r148 == true) goto L99;
            r147 = null;
        L99:
            if (r147 == null) goto L101;
            int r149 = UtilityKotlinExtentionsKt.b(r147);
        L102:
            Integer r150 = Integer.valueOf(r144.getHeight());
            if (r150.intValue() <= 0) goto L105;
            boolean r151 = true;
        L106:
            if (r151 == true) goto L109;
            r150 = null;
        L109:
            if (r150 == null) goto L111;
            int r152 = UtilityKotlinExtentionsKt.b(r150);
        L112:
            r146.setLayoutParams(new LinearLayoutCompat.LayoutParams(r149, r152));
            if (r149 != (-2)) goto L116;
            if (r152 != (-2)) goto L116;
            r111 = 33;
        L121:
            r146.setAdjustMode(r111);
            Integer r153 = Integer.valueOf(r149);
            if (r153.intValue() <= 0) goto L124;
            boolean r154 = true;
        L125:
            if (r154 == true) goto L128;
            r153 = null;
        L128:
            if (r153 == null) goto L130;
            Integer r155 = Integer.valueOf(r153.intValue() * 3);
        L131:
            Integer r156 = Integer.valueOf(r152);
            if (r156.intValue() <= 0) goto L134;
            r102 = true;
        L134:
            if (r102 == true) goto L137;
            r156 = null;
        L137:
            if (r156 == null) goto L139;
            r108 = Integer.valueOf(r156.intValue() * 3);
        L139:
            int r157 = r.f44937h;
            ECDraweeView r158 = r146;
            h0.d(r158, r144, r.a.b("ec_live_user_info_introduction"), r155, r108, null, null, 96);
            r120 = r146;
            goto L21
        L130:
            r155 = null;
            goto L131
        L124:
            r154 = false;
        L116:
            if (r149 != (-2)) goto L118;
            r111 = 1;
            goto L121
        L118:
            if (r152 == (-2)) goto L121;
            r111 = 0;
            goto L121
        L111:
            r152 = -2;
            goto L112
        L105:
            r151 = false;
            goto L106
        L101:
            r149 = -2;
            goto L102
        L95:
            r148 = false;
        L140:
            if (r105 == 0) goto L3;
            ViewGroup.LayoutParams r159 = r105.getLayoutParams();
            if (r159 == null) goto L146;
            LinearLayoutCompat.LayoutParams r160 = r100.generateLayoutParams(r159);
            if (r160 == null) goto L146;
        L148:
            if (r100.getChildCount() <= 0) goto L150;
            r160.setMarginStart(UtilityKotlinExtentionsKt.d(4));
        L150:
            Unit r161 = Unit.INSTANCE;
            r100.addView(r105, r160);
        L146:
            r160 = new LinearLayoutCompat.LayoutParams(-2, -2);
            goto L148
        L151:
            this.$introductionLayout.setVisibility(0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ECAuthorArea.e> r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public ECUserInfoIntroductionPresenter$onBind$2(c r100) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ECUserInfoState.d r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        List<ECAuthorArea.e> r101 = r100.f153007a;
        int r102 = c.f152991e;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ECUserInfoState.d r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
