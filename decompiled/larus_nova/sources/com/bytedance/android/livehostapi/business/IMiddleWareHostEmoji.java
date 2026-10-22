package com.bytedance.android.livehostapi.business;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livehostapi.platform.base.IBaseHostLog;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.ISelfEmoji;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.ss.android.ugc.aweme.live.livehostimpl.LiveHostEmoji")
public interface IMiddleWareHostEmoji extends IService, IBaseHostLog {

    public interface ISelfEmojiListener {
        void onAddSelfEmojis(List<ISelfEmoji> r100, boolean r101, String r102);

        void onDeleteSelfEmojis(List<ISelfEmoji> r100, boolean r101, String r102);

        void onGetSelfEmojis(List<ISelfEmoji> r100);
    }

    Drawable getRealDrawable(String r100);

    List<BaseEmoji> loadAllBaseEmoji();

    void registerSelfEmojiObserver(ISelfEmojiListener r100, String r101);

    void unregisterSelfEmojiObserver(String r100);
}
