package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\nR\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContent;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContentDef;", "", "getUpdateMode", "()I", "updateMode", "", "isTimerPush", "()Z", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerLinkedListChangeContent extends c<ILinkerLinkedListChangeContent>, ILinkerLinkedListChangeContentDef {
    public static final Companion Companion = null;
    public static final int PUSH_TYPE_NORMAL = 0;
    public static final int PUSH_TYPE_TIME = 1;
    public static final int UPDATE_MODE_FORCE = 1;
    public static final int UPDATE_MODE_NORMAL = 0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContent$Companion;", "", "()V", "PUSH_TYPE_NORMAL", "", "PUSH_TYPE_TIME", "UPDATE_MODE_FORCE", "UPDATE_MODE_NORMAL", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int PUSH_TYPE_NORMAL = 0;
        public static final int PUSH_TYPE_TIME = 1;
        public static final int UPDATE_MODE_FORCE = 1;
        public static final int UPDATE_MODE_NORMAL = 0;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        public static boolean isTimerPush(ILinkerLinkedListChangeContent r100) {
            if (r100.getPushType() == 1) goto L7;
            return false;
        L7:
            return true;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    int getUpdateMode();

    boolean isTimerPush();
}
