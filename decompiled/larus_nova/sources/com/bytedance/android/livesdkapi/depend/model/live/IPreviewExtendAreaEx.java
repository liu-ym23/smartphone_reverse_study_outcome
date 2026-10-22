package com.bytedance.android.livesdkapi.depend.model.live;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExtendAreaEx;", "", "getBottomPartKmp", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPart;", "getMidPartKmp", "getRightPartKmp", "useWithTitleConfig", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPreviewExtendAreaEx {
    List<IPart> getBottomPartKmp();

    List<IPart> getMidPartKmp();

    List<IPart> getRightPartKmp();

    boolean useWithTitleConfig();
}
