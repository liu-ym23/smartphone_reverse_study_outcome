package com.bytedance.android.livesdkapi.sti.framework;

import android.view.View;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u001e\u001a\u00020\u001fH&J\u0012\u0010 \u001a\u00020\u000e2\b\b\u0001\u0010!\u001a\u00020\u0005H&J\b\u0010\"\u001a\u00020\u001fH&J\b\u0010#\u001a\u00020\u001fH&R\u0018\u0010\u0004\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u0014X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0014X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/ITiltedTempIconTemplate;", "Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "Lcom/bytedance/android/livesdkapi/sti/framework/ICommonTemplateFeature;", "Lcom/bytedance/android/livesdkapi/sti/framework/Instantiable;", "contentRightMargin", "", "getContentRightMargin", "()I", "setContentRightMargin", "(I)V", "contentTopMargin", "getContentTopMargin", "setContentTopMargin", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "isRotated", "", "()Ljava/lang/Boolean;", "setRotated", "(Ljava/lang/Boolean;)V", "resizeContentView", "getResizeContentView", "setResizeContentView", "tempShortTermView", "getTempShortTermView", "setTempShortTermView", "clearAnimators", "", "inflateContentView", "resId", "removeTempView", ChatMatchViewModel.ENTER_METHOD_SHAKE, "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITiltedTempIconTemplate extends IconTemplate, ICommonTemplateFeature, Instantiable {
    void clearAnimators();

    int getContentRightMargin();

    int getContentTopMargin();

    View getContentView();

    Boolean getResizeContentView();

    View getTempShortTermView();

    View inflateContentView(int r100);

    Boolean isRotated();

    void removeTempView();

    void setContentRightMargin(int r100);

    void setContentTopMargin(int r100);

    void setContentView(View r100);

    void setResizeContentView(Boolean r100);

    void setRotated(Boolean r100);

    void setTempShortTermView(View r100);

    void shake();
}
