package com.bytedance.ai.widget.cache;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.widget.contianer.m;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes43.dex */
public interface b {
    Object a(Continuation<? super Widget> r100);

    void b(ConversationWidgetData r100);

    Object c(Continuation<? super TemplateBundle> r100);

    void d(String r100, String r101, String r102, String r103, String r104);

    TemplateData e();

    Uri f();

    Object g(Context r100, m r101, Continuation<? super Unit> r102);
}
