package com.alibaba.gaiax.render.view.basic.spannable;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/ClickableNoStyleSpan;", "Landroid/text/style/ClickableSpan;", "schema", "", "(Ljava/lang/String;)V", SendEventContainerMethodParamModel.EventKinds.onClick, "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClickableNoStyleSpan extends ClickableSpan {
    private final String schema;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    public ClickableNoStyleSpan(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.schema = r100;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        throw new NotImplementedError("An operation is not implemented:  TODO sd 需要将点击事件代理出去。点击协议为schema形式，里面定义点击行为和参数");
    }
}
