package com.bytedance.android.format.omni.api;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import sr.a;
import sr.b;
import sr.d;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/format/omni/api/IFormatOmniWidgetDescriptor;", "", "", "bizTag", "Lsr/a;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "canLoadWidget", "Lsr/d;", "createWidget", "Ljava/lang/Class;", "widgetClass", "Lsr/b;", "uiInfo", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFormatOmniWidgetDescriptor {
    String bizTag();

    boolean canLoadWidget(a r100);

    d createWidget(a r100);

    b uiInfo();

    Class<? extends d> widgetClass();
}
