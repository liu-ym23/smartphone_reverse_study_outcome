package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.a;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/ChannelItemProduct;", "Landroid/widget/FrameLayout;", "", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "b", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "getChannel", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "setChannel", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;)V", "channel", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelItemProduct extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f177706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ChannelVO f177707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f177708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f177709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f177710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f177711f;

    public ChannelItemProduct(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChannelItemProduct(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public ChannelVO getChannel() {
        return this.f177707b;
    }

    public int getIndex() {
        return this.f177706a;
    }

    public void setChannel(ChannelVO r100) {
        this.f177707b = r100;
    }

    public void setIndex(int r100) {
        this.f177706a = r100;
    }

    public ChannelItemProduct(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f177706a = -1;
        this.f177708c = ContextCompat.getColor(r110, R.color.shopping_home_color_161823);
        this.f177709d = ContextCompat.getColor(r110, R.color.shopping_home_color_BF161823);
        SimpleDraweeView r100 = new SimpleDraweeView(r110);
        this.f177710e = r100;
        AppCompatTextView r101 = new AppCompatTextView(r110);
        BackgroundDrawable r102 = new BackgroundDrawable(r110, r111, false, 4, null);
        r102.setBgColor(ContextCompat.getColor(r110, R.color.shopping_home_color_F5F6F9));
        int r113 = c.f47296a;
        r102.setStrokeWidth(c.c(Double.valueOf(0.5d), r110, true));
        r102.setCornerRadius(c.c(100, r110, true));
        r102.setStrokeColor(ContextCompat.getColor(r110, R.color.shopping_home_color_FFFFFF));
        r102.invalidate();
        Unit r114 = Unit.INSTANCE;
        r101.setBackground(r102);
        r101.setTextSize(0, c.c(10, r110, true));
        ViewCompat.setPaddingRelative(r101, c.c(5, r110, true), c.c(1, r110, true), c.c(5, r110, true), 0);
        this.f177711f = r101;
        addView(r100, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(-2, c.c(15, r110, true));
        r115.gravity = 81;
        addView(r101, r115);
    }

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
    public final void a(ChannelVO r100, a r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "mallContext");
        setChannel(r100);
        setIndex(r110);
        if (r110 < 0) goto L62;
        ChannelVO r102 = getChannel();
        SpannableStringBuilder r103 = null;
        Typeface r104 = null;
        r104 = null;
        if (r102 == null) goto L8;
        String r105 = r102.getItemImageUrl(r110);
    L9:
        boolean r106 = true;
        if (r105 != null) goto L12;
    L15:
        boolean r107 = true;
    L16:
        if (r107 == true) goto L18;
        d0.c(this.f177710e, r105, r101.f177572k);
    L18:
        SpannableStringBuilder r108 = new SpannableStringBuilder();
        int r109 = this.f177709d;
        ChannelVO r111 = getChannel();
        if (r111 == null) goto L21;
        Boolean r112 = Boolean.valueOf(r111.showItemPrice(r110));
    L22:
        ChannelVO r113 = getChannel();
        if (r113 == null) goto L25;
        Boolean r114 = Boolean.valueOf(r113.showItemTag(r110));
    L26:
        Boolean r115 = Boolean.TRUE;
        if (Intrinsics.areEqual(r112, r115) == false) goto L29;
        r108.append("¥");
        r109 = this.f177708c;
    L29:
        ChannelVO r116 = getChannel();
        if (r116 == null) goto L32;
        String r117 = r116.getItemPriceOrTag(r110);
    L33:
        if (r117 != null) goto L35;
    L38:
        boolean r118 = true;
    L39:
        if (r118 == true) goto L52;
        r108.append(r117);
        r108.setSpan(new ForegroundColorSpan(r109), 0, r108.length(), 17);
        if (Build.VERSION.SDK_INT >= 28) goto L44;
    L51:
        r103 = r108;
        goto L52
    L44:
        if (Intrinsics.areEqual(r112, r115) == false) goto L47;
        com.bytedance.android.ec.hybrid.a.c();
    L49:
        if (r104 == null) goto L51;
        r108.setSpan(new TypefaceSpan(r104), 0, r108.length(), 17);
        goto L51
    L47:
        if (Intrinsics.areEqual(r114, r115) == false) goto L49;
        r104 = Typeface.create(Typeface.create("PingFang SC", 0), 600, false);
    L52:
        if (r103 != null) goto L54;
    L57:
        if (r106 == true) goto L59;
        this.f177711f.setText(r103);
        this.f177711f.setVisibility(0);
        return;
    L59:
        this.f177711f.setVisibility(8);
        return;
    L54:
        if (r103.length() == 0) goto L57;
        r106 = false;
        goto L57
    L35:
        if (r117.length() == 0) goto L38;
        r118 = false;
        goto L39
    L32:
        r117 = null;
        goto L33
    L25:
        r114 = null;
        goto L26
    L21:
        r112 = null;
        goto L22
    L12:
        if (r105.length() == 0) goto L15;
        r107 = false;
        goto L16
    L8:
        r105 = null;
        goto L9
    }

    public /* synthetic */ ChannelItemProduct(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
