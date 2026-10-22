package com.bytedance.android.livehostapi.foundation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.livehostapi.business.IHostEmoji;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.SelfEmoji;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/LiveHostEmoji;", "Lcom/bytedance/android/livehostapi/business/IHostEmoji;", "()V", "addSelfEmoji", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "selfEmoji", "Lcom/bytedance/android/livehostapi/business/model/emoji/SelfEmoji;", "getRealDrawable", "Landroid/graphics/drawable/Drawable;", "emojiText", "", "loadAllBaseEmoji", "", "Lcom/bytedance/android/livehostapi/business/model/emoji/BaseEmoji;", "manageSelfEmoji", "previewSelfEmoji", "registerSelfEmojiObserver", "observer", "Lcom/bytedance/android/livehostapi/business/IMiddleWareHostEmoji$ISelfEmojiListener;", "observerTag", "unregisterSelfEmojiObserver", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public final class LiveHostEmoji implements IHostEmoji {
    @Override // com.bytedance.android.livehostapi.business.IHostEmoji
    public void manageSelfEmoji(Context r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji
    public void registerSelfEmojiObserver(IMiddleWareHostEmoji.ISelfEmojiListener r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "observer");
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji
    public void unregisterSelfEmojiObserver(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji
    public List<BaseEmoji> loadAllBaseEmoji() {
        ArrayList r100 = new ArrayList();
        List<BaseEmoji> r101 = ((IAwemeEmojiProxy) k.n(IAwemeEmojiProxy.class)).loadAllBaseEmoji();
        if (r101 == null) goto L5;
        r100.addAll(r101);
    L5:
        return r100;
    }

    public LiveHostEmoji() {
        k.l(IHostEmoji.class, this);
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji
    public Drawable getRealDrawable(String r100) {
        IAwemeEmojiProxy r101 = (IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getRealDrawable(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostEmoji
    public void addSelfEmoji(Context r100, SelfEmoji r101) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.bytedance.android.livehostapi.business.IHostEmoji
    public void previewSelfEmoji(Context r100, SelfEmoji r101) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
