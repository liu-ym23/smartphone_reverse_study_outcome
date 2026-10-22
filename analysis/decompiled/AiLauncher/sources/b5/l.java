package b5;

import Z8.C1172u;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.random.Random;
import p9.InterfaceC5063a;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R,\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u00120\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0018"}, d2 = {"Lb5/l;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "", QueryAlgorithmBundle.KEY_CATEGORY, "categoryName", "", "index", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;I)Lcom/stepos/ailauncher/agent/skill/SkillItem;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "statuses", "Ljava/util/List;", "Lkotlin/Triple;", "categoryDefs", "all$delegate", "LY8/h;", "e", "all", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    public static final l INSTANCE = new l();
    private static final List<SkillStatus> statuses = C1173v.p(SkillStatus.UNINSTALLED, SkillStatus.INSTALLED_ENABLED, SkillStatus.INSTALLED_DISABLED, SkillStatus.INSTALL_FAILED);
    private static final List<Triple<String, String, Integer>> categoryDefs = C1173v.p(new Triple("0", "装机必备", 5), new Triple("1", "其它", 100));

    /* renamed from: all$delegate, reason: from kotlin metadata */
    private static final Y8.h all = C4848b.b(new InterfaceC5063a() { // from class: b5.k
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return l.c();
        }
    });

    public static final List c() {
        List listC = C1172u.c();
        Iterator<T> it = categoryDefs.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            String str = (String) triple.a();
            String str2 = (String) triple.b();
            int iIntValue = ((Number) triple.c()).intValue();
            for (int i10 = 0; i10 < iIntValue; i10++) {
                listC.add(INSTANCE.d(str, str2, i10));
            }
        }
        return C1172u.a(listC);
    }

    public final List<SkillItem> b() {
        return e();
    }

    public final SkillItem d(String category, String categoryName, int index) {
        String str = "cat" + category + "_" + index;
        String str2 = "cat" + category + "_" + index;
        int i10 = index + 1;
        String str3 = categoryName + "_" + i10;
        String str4 = "这是 " + categoryName + " 第 " + i10 + " 个技能的简介……";
        List listP = C1173v.p("官方推荐", "社区贡献", "合作伙伴", "热门排行");
        Random.Companion companion = Random.INSTANCE;
        return new SkillItem(str, str2, str3, str4, (String) F.U0(listP, companion), null, null, null, null, null, null, null, null, null, null, null, null, category, categoryName, C5685n.q(new C5680i(1000, 99999), companion), 0, null, null, 0, null, null, null, null, null, null, null, (SkillStatus) F.U0(statuses, companion), null, null, null, null, 2146566112, 15, null);
    }

    public final List<SkillItem> e() {
        return (List) all.getValue();
    }
}
