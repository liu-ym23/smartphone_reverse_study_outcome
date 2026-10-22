package aib;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImSdkChatService f3867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f3868b;

    /* JADX INFO: renamed from: aib.a$a, reason: collision with other inner class name */
    public static final class C0073a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Chat f3869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ChatChatter f3870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ChatChatter f3871c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0073a) == true) goto L8;
            return false;
        L8:
            C0073a r101 = (C0073a) r100;
            if (Intrinsics.areEqual(this.f3869a, r101.f3869a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f3870b, r101.f3870b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f3871c, r101.f3871c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Chat r100 = this.f3869a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            ChatChatter r104 = this.f3870b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            ChatChatter r107 = this.f3871c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "FlowReplyInThreadInitData(chat=" + this.f3869a + ", p2pChatter=" + this.f3870b + ", selfChatter=" + this.f3871c + ')';
        }

        public C0073a(Chat r100, ChatChatter r101, ChatChatter r102) {
            this.f3869a = r100;
            this.f3870b = r101;
            this.f3871c = r102;
        }
    }

    public a(ImSdkChatService r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "chatService");
        Intrinsics.checkNotNullParameter(r101, "chatterService");
        this.f3867a = r100;
        this.f3868b = r101;
    }
}
