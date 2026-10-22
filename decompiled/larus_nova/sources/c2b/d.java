package c2b;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.n;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<Message.Type> f22253e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, d> f22254f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f22255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f22258d;

    static {
        f22253e = Arrays.asList(new Message.Type[]{Message.Type.TEXT, Message.Type.POST, Message.Type.FILE, Message.Type.IMAGE, Message.Type.AUDIO, Message.Type.STICKER, Message.Type.MEDIA, Message.Type.RED_PACKET});
        f22254f = new HashMap();
    }

    public d(String r100) {
        new HashSet();
        new HashSet();
        this.f22256b = r100;
        if (r100 != null) goto L5;
        r100 = "unDeclared";
    L5:
        this.f22258d = PThreadExecutorsUtils.newScheduledThreadPool(1, new n("MsgReadIssueTracker_".concat(r100)));
    }

    public static d b(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        Map<String, d> r101 = f22254f;
        monitor-enter(r101);
        d r102 = (d) ((HashMap) r101).get(r100);     // Catch: Throwable -> L13
        if (r102 != null) goto L11;
        r102 = new d(r100);     // Catch: Throwable -> L13
        ((HashMap) r101).put(r100, r102);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return r102;
    L13:
        th = move-exception;
        throw th;
    L5:
        return new d("");
    }

    public final void c(String r100) {
        if (this.f22257c == true) goto L5;
        return;
    L5:
        c r101 = this.f22255a.a(r100);
        List<MessageInfo> r102 = r101.f22251a;
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L13;
        return;
    L13:
        if (r101.f22252b != null) goto L17;
        r101.f22252b = (MessageInfo) ListProtector.get(r101.f22251a, 0);
        return;
    L17:
        return;
    L8:
        if (r102.isEmpty() == true) goto L10;
        r103 = true;
        goto L11
    }

    public final void a(Chat r100, a r101) {
        if (TextUtils.isEmpty(this.f22256b) == true) goto L16;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f22256b.equals(r100.getId()) == true) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.f22256b) == false) goto L11;
    L13:
        boolean r102 = false;
    L14:
        this.f22257c = r102;
        this.f22255a = r101;
        r100.getP2pChatterId();
        return;
    L11:
        if (r100.getUserCount() >= 50) goto L13;
        r102 = true;
        goto L14
    }
}
