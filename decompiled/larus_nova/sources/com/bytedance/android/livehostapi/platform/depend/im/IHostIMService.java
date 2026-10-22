package com.bytedance.android.livehostapi.platform.depend.im;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.live.base.model.user.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&J2\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&J*\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u00070\u0006H&J2\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&J^\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\"\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00172\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011H&J(\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u0006H&J\b\u0010\u001e\u001a\u00020\u0007H&J\b\u0010 \u001a\u00020\u001fH&J3\u0010&\u001a\u00028\u0000\"\u0004\b\u0000\u0010!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u001fH&¢\u0006\u0004\b&\u0010'¨\u0006(À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/depend/im/IHostIMService;", "", "", "spUid", "", "role", "Lkotlin/Function1;", "", "callback", "getConsultMsgUnreadCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livehostapi/platform/depend/im/LiveEnterChatParams;", "liveEnterParams", "Lcom/bytedance/android/livehostapi/platform/depend/im/LiveIMError2;", "startChat", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "Lcom/bytedance/android/live/base/model/user/f;", "getChatChannelGroups", "startGroupChat", "extra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "log", "startConsultConList", "Lcom/bytedance/android/livehostapi/platform/depend/im/IMEmoji;", "getInteractiveEmojiData", "name", "getEmojiVideoPathByName", "liveRoomClose", "", "isEnable", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "service", "baseUrl", "needImMonitor", "create", "(Ljava/lang/Class;Ljava/lang/String;Z)Ljava/lang/Object;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostIMService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.depend.im.IHostIMService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startChat$default(IHostIMService r100, Context r101, LiveEnterChatParams r102, Function1 r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.startChat(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startChat");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startGroupChat$default(IHostIMService r100, Context r101, LiveEnterChatParams r102, Function1 r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.startGroupChat(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startGroupChat");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void startConsultConList$default(IHostIMService r100, String r101, int r102, String r103, HashMap r110, Function1 r111, int r112, Object r113) {
            if (r113 != null) goto L9;
            if ((r112 & 16) == 0) goto L6;
            r111 = null;
        L6:
            r100.startConsultConList(r101, r102, r103, r110, r111);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startConsultConList");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void startChat$default(IHostIMService r100, Context r101, LiveEnterChatParams r102, Function1 r103, int r104, Object r105) {
            CC.startChat$default(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ void startGroupChat$default(IHostIMService r100, Context r101, LiveEnterChatParams r102, Function1 r103, int r104, Object r105) {
            CC.startGroupChat$default(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ void startConsultConList$default(IHostIMService r100, String r101, int r102, String r103, HashMap r104, Function1 r105, int r106, Object r107) {
            CC.startConsultConList$default(r100, r101, r102, r103, r104, r105, r106, r107);
        }
    }

    <T> T create(Class<T> r100, String r101, boolean r102);

    void getChatChannelGroups(int r100, Function1<? super List<? extends f>, Unit> r101);

    void getConsultMsgUnreadCount(String r100, int r101, Function1<? super Integer, Unit> r102);

    void getEmojiVideoPathByName(String r100, Function1<? super String, Unit> r101);

    List<IMEmoji> getInteractiveEmojiData();

    boolean isEnable();

    void liveRoomClose();

    void startChat(Context r100, LiveEnterChatParams r101, Function1<? super LiveIMError2, Unit> r102);

    void startConsultConList(String r100, int r101, String r102, HashMap<String, String> r103, Function1<? super LiveIMError2, Unit> r104);

    void startGroupChat(Context r100, LiveEnterChatParams r101, Function1<? super LiveIMError2, Unit> r102);
}
