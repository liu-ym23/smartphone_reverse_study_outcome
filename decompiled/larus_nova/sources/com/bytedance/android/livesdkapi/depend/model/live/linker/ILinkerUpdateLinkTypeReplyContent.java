package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeReplyContent;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeReplyContentDef;", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerUpdateLinkTypeReplyContent extends c<ILinkerUpdateLinkTypeReplyContent>, ILinkerUpdateLinkTypeReplyContentDef {
    public static final Companion Companion = null;
    public static final int UPDATE_LINK_TYPE_REPLY_AGREE = 1;
    public static final int UPDATE_LINK_TYPE_REPLY_REJECT = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeReplyContent$Companion;", "", "()V", "UPDATE_LINK_TYPE_REPLY_AGREE", "", "UPDATE_LINK_TYPE_REPLY_REJECT", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int UPDATE_LINK_TYPE_REPLY_AGREE = 1;
        public static final int UPDATE_LINK_TYPE_REPLY_REJECT = 2;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);
}
