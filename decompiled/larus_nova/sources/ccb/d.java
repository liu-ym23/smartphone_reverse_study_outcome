package ccb;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ChatChatter> f23345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ChatChatter> f23346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ChatChatter> f23347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f23348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f23349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f23350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<UserGroupEntity> f23351g;

    public d() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new HashMap(), false, "");
    }

    public d(List<ChatChatter> r100, List<ChatChatter> r101, List<ChatChatter> r102, List<UserGroupEntity> r103, Map<String, String> r110, boolean r111, String r112) {
        ArrayList r104 = new ArrayList();
        this.f23345a = r104;
        ArrayList r105 = new ArrayList();
        this.f23346b = r105;
        ArrayList r106 = new ArrayList();
        this.f23347c = r106;
        HashMap r107 = new HashMap();
        this.f23348d = r107;
        ArrayList r108 = new ArrayList();
        this.f23351g = r108;
        CollectionUtils.resetToList(r104, r100);
        CollectionUtils.resetToList(r105, r101);
        CollectionUtils.resetToList(r106, r102);
        CollectionUtils.resetToList(r108, r103);
        if (CollectionUtils.isNotEmpty(r110) == false) goto L5;
        r107.putAll(r110);
    L5:
        this.f23349e = r111;
        this.f23350f = r112;
    }
}
