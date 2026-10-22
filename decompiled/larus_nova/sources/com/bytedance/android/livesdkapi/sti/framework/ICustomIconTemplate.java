package com.bytedance.android.livesdkapi.sti.framework;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0012\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\fH&R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/ICustomIconTemplate;", "Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "Lcom/bytedance/android/livesdkapi/sti/framework/ICommonTemplateFeature;", "Lcom/bytedance/android/livesdkapi/sti/framework/Instantiable;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "inflateContentView", "resId", "", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICustomIconTemplate extends IconTemplate, ICommonTemplateFeature, Instantiable {
    View getContentView();

    View inflateContentView(int r100);

    void setContentView(View r100);
}
