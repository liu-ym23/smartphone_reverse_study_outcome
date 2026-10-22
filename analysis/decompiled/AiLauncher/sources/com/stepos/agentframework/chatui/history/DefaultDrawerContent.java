package com.stepos.agentframework.chatui.history;

import Ua.C1060i;
import Ua.M;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.utils.n;
import com.stepos.agentframework.util.C2154c;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\u001c\u001a*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u001aj\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017`\u001b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010$R(\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00180,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R&\u00104\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/stepos/agentframework/chatui/history/DefaultDrawerContent;", "Lcom/stepos/agentframework/chatui/history/i;", "LUa/M;", "viewScope", "<init>", "(LUa/M;)V", "Landroid/view/View;", "navContentRoot", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "LY8/t;", "r", "(Landroid/view/View;Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "", "currentSessionId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "sessionId", "k", "n", "newTitle", "t", "(Ljava/lang/String;Ljava/lang/String;)V", "", "Lw4/e;", "conversations", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "q", "(Ljava/util/List;)Ljava/util/LinkedHashMap;", "", "timeMillis", "p", "(J)J", "o", "(J)Ljava/lang/String;", "LUa/M;", "Lkotlin/Function0;", "closeDrawerFun", "Lp9/a;", "getCloseDrawerFun", "()Lp9/a;", "u", "(Lp9/a;)V", "Lcom/stepos/agentframework/chatui/history/h;", "adapter", "Lcom/stepos/agentframework/chatui/history/h;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lkotlin/Function2;", "clickListener", "Lp9/p;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultDrawerContent implements i {
    private h<w4.e> adapter;
    private final p<String, w4.e, t> clickListener;
    private InterfaceC5063a<t> closeDrawerFun;
    private Context context;
    private SessionHandler sessionHandler;
    private final M viewScope;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((String) ((Map.Entry) t11).getKey(), (String) ((Map.Entry) t10).getKey());
        }
    }

    public DefaultDrawerContent(M viewScope) {
        kotlin.jvm.internal.p.i(viewScope, "viewScope");
        this.viewScope = viewScope;
        this.closeDrawerFun = new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.history.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DefaultDrawerContent.m();
            }
        };
        this.clickListener = new p() { // from class: com.stepos.agentframework.chatui.history.c
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return DefaultDrawerContent.l(this.f22968a, (String) obj, (w4.e) obj2);
            }
        };
    }

    public static final t l(DefaultDrawerContent defaultDrawerContent, String mode, w4.e title) {
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(title, "title");
        int iHashCode = mode.hashCode();
        if (iHashCode != -1335458389) {
            if (iHashCode != -1039745817) {
                if (iHashCode == -934594754 && mode.equals(W4.c.MANAGE_RENAME)) {
                    defaultDrawerContent.t(title.getSessionId(), title.getTitle());
                }
            } else if (mode.equals("normal")) {
                defaultDrawerContent.k(title.getSessionId());
            }
        } else if (mode.equals(ChatTracker.CLICK_DELETE)) {
            defaultDrawerContent.n(title.getSessionId());
        }
        return t.f7040a;
    }

    public static final t m() {
        return t.f7040a;
    }

    public static final t s(View it) {
        kotlin.jvm.internal.p.i(it, "it");
        return t.f7040a;
    }

    @Override // com.stepos.agentframework.chatui.history.i
    public void a(final String currentSessionId) {
        kotlin.jvm.internal.p.i(currentSessionId, "currentSessionId");
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null) {
            kotlin.jvm.internal.p.A("sessionHandler");
            sessionHandler = null;
        }
        sessionHandler.n2(new AgentSession.e() { // from class: com.stepos.agentframework.chatui.history.DefaultDrawerContent$loadData$1

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class a<T> implements Comparator {
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t10, T t11) {
                    return b9.b.d(Long.valueOf(((w4.e) t11).getLastActiveAt()), Long.valueOf(((w4.e) t10).getLastActiveAt()));
                }
            }

            @Override // com.stepos.agentframework.chatcore.session.AgentSession.e
            public void a(List<w4.e> titles) {
                List listM;
                if (titles == null || (listM = F.c1(titles, new a())) == null) {
                    listM = C1173v.m();
                }
                ArrayList arrayList = new ArrayList();
                LinkedHashMap linkedHashMapQ = this.this$0.q(listM);
                String str = currentSessionId;
                DefaultDrawerContent defaultDrawerContent = this.this$0;
                for (Map.Entry entry : linkedHashMapQ.entrySet()) {
                    String str2 = (String) entry.getKey();
                    List<w4.e> list = (List) entry.getValue();
                    arrayList.add(new DrawerTitleItem(1, str2, 0, null, false, null, 48, null));
                    for (w4.e eVar : list) {
                        arrayList.add(new DrawerTitleItem(0, eVar.getTitle(), eVar.getSessionKind(), eVar, kotlin.jvm.internal.p.d(str, eVar.getSessionId()), defaultDrawerContent.clickListener));
                    }
                }
                C1060i.d(this.this$0.viewScope, null, null, new DefaultDrawerContent$loadData$1$onLoadConversationTitles$2(this.this$0, arrayList, null), 3, null);
            }
        });
    }

    public final void k(String sessionId) {
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null) {
            kotlin.jvm.internal.p.A("sessionHandler");
            sessionHandler = null;
        }
        sessionHandler.N0(sessionId);
        this.closeDrawerFun.invoke();
    }

    public final void n(String sessionId) {
        n nVar = n.INSTANCE;
        Context context = this.context;
        Context context2 = null;
        if (context == null) {
            kotlin.jvm.internal.p.A("context");
            context = null;
        }
        if (nVar.b(context)) {
            SessionHandler sessionHandler = this.sessionHandler;
            if (sessionHandler == null) {
                kotlin.jvm.internal.p.A("sessionHandler");
                sessionHandler = null;
            }
            SessionHandler.h1(sessionHandler, sessionId, null, 2, null);
            return;
        }
        Context context3 = this.context;
        if (context3 == null) {
            kotlin.jvm.internal.p.A("context");
        } else {
            context2 = context3;
        }
        Toast.makeText(context2, R$string.chat_network_error_retry_later, 0).show();
    }

    public final String o(long timeMillis) {
        String str = new SimpleDateFormat("yyyy年MM月", Locale.getDefault()).format(new Date(timeMillis));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final long p(long timeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinkedHashMap<String, List<w4.e>> q(List<w4.e> conversations) {
        LinkedHashMap<String, List<w4.e>> linkedHashMap = new LinkedHashMap<>();
        long jP = p(System.currentTimeMillis());
        long j10 = jP - 86400000;
        long j11 = jP - 604800000;
        long j12 = jP - (-1702967296);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (w4.e eVar : conversations) {
            long j13 = jP;
            long j14 = j10;
            long lastActiveAt = eVar.getLastActiveAt();
            if (lastActiveAt >= j13) {
                arrayList.add(eVar);
            } else if (lastActiveAt >= j14) {
                arrayList2.add(eVar);
            } else if (lastActiveAt >= j11) {
                arrayList3.add(eVar);
            } else if (lastActiveAt >= j12) {
                arrayList4.add(eVar);
            } else {
                String strO = o(lastActiveAt);
                if (!linkedHashMap2.containsKey(strO)) {
                    linkedHashMap2.put(strO, new ArrayList());
                }
                List list = (List) linkedHashMap2.get(strO);
                if (list != null) {
                    list.add(eVar);
                }
            }
            jP = j13;
            j10 = j14;
        }
        if (!arrayList.isEmpty()) {
            linkedHashMap.put("今天", arrayList);
        }
        if (!arrayList2.isEmpty()) {
            linkedHashMap.put("昨天", arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            linkedHashMap.put("7天内", arrayList3);
        }
        if (!arrayList4.isEmpty()) {
            linkedHashMap.put("30天内", arrayList4);
        }
        for (Map.Entry entry : F.c1(linkedHashMap2.entrySet(), new a())) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public void r(View navContentRoot, SessionHandler sessionHandler) {
        kotlin.jvm.internal.p.i(navContentRoot, "navContentRoot");
        kotlin.jvm.internal.p.i(sessionHandler, "sessionHandler");
        RecyclerView recyclerView = (RecyclerView) navContentRoot.findViewById(R$id.rcv);
        this.sessionHandler = sessionHandler;
        Context context = navContentRoot.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        this.context = context;
        kotlin.jvm.internal.p.f(recyclerView);
        h<w4.e> hVar = new h<>(recyclerView);
        this.adapter = hVar;
        hVar.c();
        View viewFindViewById = navContentRoot.findViewById(R$id.ivSearch);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        C2154c.b(viewFindViewById, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.history.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DefaultDrawerContent.s((View) obj);
            }
        });
    }

    public final void t(String sessionId, String newTitle) {
        C1060i.d(this.viewScope, null, null, new DefaultDrawerContent$renameConversion$1(this, newTitle, sessionId, null), 3, null);
    }

    public final void u(InterfaceC5063a<t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(interfaceC5063a, "<set-?>");
        this.closeDrawerFun = interfaceC5063a;
    }
}
