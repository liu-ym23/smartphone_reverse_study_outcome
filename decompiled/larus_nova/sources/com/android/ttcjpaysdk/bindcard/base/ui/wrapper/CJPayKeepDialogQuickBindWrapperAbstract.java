package com.android.ttcjpaysdk.bindcard.base.ui.wrapper;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayKeepDialogBean;
import com.android.ttcjpaysdk.bindcard.base.ui.fragment.CJPayBindCardKeepDialogFragment;
import com.android.ttcjpaysdk.thirdparty.view.CJPayRoundCornerImageView;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0006\u0010\u001d\u001a\u00020\u001eR\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayKeepDialogQuickBindWrapperAbstract;", "Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/CJPayBindCardKeepDialogBaseWrapper;", "contentView", "Landroid/view/View;", CJPayBindCardKeepDialogFragment.DIALOG_BEAN_KEY, "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayKeepDialogBean;", "(Landroid/view/View;Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayKeepDialogBean;)V", "btnContinue", "Landroid/widget/TextView;", "getBtnContinue", "()Landroid/widget/TextView;", "flBankIcons", "Landroid/widget/FrameLayout;", "ivBankIconA", "Lcom/android/ttcjpaysdk/thirdparty/view/CJPayRoundCornerImageView;", "ivBankIconB", "ivBankIconBgA", "ivBankIconBgB", "ivBankIconBgC", "ivBankIconC", "tvExit", "getTvExit", "()Landroid/view/View;", "tvSubTitle", "tvTitle", "getContinueBtn", "getContinueBtnClickListener", "Landroid/view/View$OnClickListener;", "getExitBtn", "initView", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CJPayKeepDialogQuickBindWrapperAbstract extends CJPayBindCardKeepDialogBaseWrapper {
    private final CJPayKeepDialogBean dialogBean;
    private final FrameLayout flBankIcons;
    private final CJPayRoundCornerImageView ivBankIconA;
    private final CJPayRoundCornerImageView ivBankIconB;
    private final View ivBankIconBgA;
    private final View ivBankIconBgB;
    private final View ivBankIconBgC;
    private final CJPayRoundCornerImageView ivBankIconC;
    private final TextView tvSubTitle;
    private final TextView tvTitle;

    public abstract TextView getBtnContinue();

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.CJPayBindCardKeepDialogBaseWrapper
    public View.OnClickListener getContinueBtnClickListener() {
        return null;
    }

    public abstract View getTvExit();

    public final void initView() {
        CJPayKeepDialogBean r100 = this.dialogBean;
        if (r100 == null) goto L21;
        getBtnContinue().setText(getContext().getString(R.string.cj_pay_check_quick_bind_list));
        this.tvTitle.setText(r100.title);
        int r101 = getSpaceLength(this.flBankIcons, this.tvSubTitle);
        int r102 = 0;
        String r103 = "";
        if (r101 < 0) goto L10;
        int r104 = 0;
    L7:
        r103 = " " + r103;
        if (r104 == r101) goto L10;
        r104 = r104 + 1;
    L10:
        this.tvSubTitle.setText(r103 + r100.msg);
        this.flBankIcons.setVisibility(0);
        List<String> r105 = r100.getIconUrls();
        Iterator r106 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(this.ivBankIconA, this.ivBankIconBgA), TuplesKt.to(this.ivBankIconB, this.ivBankIconBgB), TuplesKt.to(this.ivBankIconC, this.ivBankIconBgC)}).iterator();
    L12:
        if (r106.hasNext() == false) goto L26;
        Object r107 = r106.next();
        int r108 = r102 + 1;
        if (r102 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        final Pair r109 = (Pair) r107;
        String r110 = (String) CollectionsKt.getOrNull(r105, r102);
        if (r110 != null) goto L19;
        ((CJPayRoundCornerImageView) r109.getFirst()).setVisibility(8);
        ((View) r109.getSecond()).setVisibility(8);
    L20:
        r102 = r108;
        goto L12
    L19:
        ImageLoader.Companion.getInstance().loadImage(r110, new CJPayKeepDialogQuickBindWrapperAbstract$initView$1$1$1(r109));
        goto L20
    L26:
        return;
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.CJPayBindCardKeepDialogBaseWrapper
    public View getContinueBtn() {
        return getBtnContinue();
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.CJPayBindCardKeepDialogBaseWrapper
    public View getExitBtn() {
        return getTvExit();
    }

    public CJPayKeepDialogQuickBindWrapperAbstract(View r100, CJPayKeepDialogBean r101) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100);
        this.dialogBean = r101;
        this.tvTitle = (TextView) r100.findViewById(R.id.keep_dialog_title_text_red);
        this.tvSubTitle = (TextView) r100.findViewById(R.id.keep_dialog_subtitle_text_red);
        this.flBankIcons = (FrameLayout) r100.findViewById(R.id.keep_dialog_subtitle_images_red);
        this.ivBankIconA = (CJPayRoundCornerImageView) r100.findViewById(R.id.keep_dialog_subtitle_image1_red);
        this.ivBankIconB = (CJPayRoundCornerImageView) r100.findViewById(R.id.keep_dialog_subtitle_image2_red);
        this.ivBankIconC = (CJPayRoundCornerImageView) r100.findViewById(R.id.keep_dialog_subtitle_image3_red);
        this.ivBankIconBgA = r100.findViewById(R.id.keep_dialog_subtitle_image1_bg);
        this.ivBankIconBgB = r100.findViewById(R.id.keep_dialog_subtitle_image2_bg);
        this.ivBankIconBgC = r100.findViewById(R.id.keep_dialog_subtitle_image3_bg);
    }
}
