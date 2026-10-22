package com.stepos.ailauncher.migu.card;

import N5.CardEnvelope;
import N5.d;
import N5.n;
import N5.v;
import R5.b;
import Y8.j;
import Z8.C1173v;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import d6.C3957a;
import d6.C3958b;
import d6.MusicSongItem;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/migu/card/MusicListCardProvider;", "LN5/v;", "<init>", "()V", "LN5/i;", "envelope", "LN5/n;", Const.INTENT_KEY_PKGNAME, "(LN5/i;)LN5/n;", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "", "raw", "", "Ld6/q;", "c", "(Ljava/lang/Object;)Ljava/util/List;", "Companion", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MusicListCardProvider implements v {
    private static final a Companion = new a(null);
    private static final Gson gson = new Gson();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/migu/card/MusicListCardProvider$a;", "", "<init>", "()V", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    @Override // N5.v
    public d a(Context context) {
        p.i(context, "context");
        return new d6.p(context, null, 0, 6, null);
    }

    @Override // N5.v
    public n b(CardEnvelope envelope) {
        p.i(envelope, "envelope");
        Map<String, Object> mapE = envelope.e();
        List<MusicSongItem> listC = c(mapE != null ? mapE.get(DidiCardProvider.KEY_ITEMS) : null);
        Object obj = mapE != null ? mapE.get("title") : null;
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = mapE != null ? mapE.get("brandName") : null;
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = mapE != null ? mapE.get("brandLogoUrl") : null;
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        boolean zA = C3957a.INSTANCE.a(mapE != null ? mapE.get("autoPlay") : null);
        b bVar = b.INSTANCE;
        String taskId = envelope.getTaskId();
        if (taskId.length() == 0) {
            taskId = "null";
        }
        String str4 = "provider.music:" + ((Object) taskId);
        String taskId2 = envelope.getTaskId();
        bVar.e(str4, "provider.parse", j.a("taskId", taskId2.length() != 0 ? taskId2 : "null"), j.a("templateType", envelope.getTemplateType()), j.a("providerCls", "MusicListCardProvider"), j.a("itemCount", Integer.valueOf(listC.size())), j.a("brandName", str2), j.a("autoPlay", Boolean.valueOf(zA)));
        return new C3958b(envelope.getTaskId(), str, str2, str3, listC, zA);
    }

    public final List<MusicSongItem> c(Object raw) {
        Object objB;
        if (raw == null) {
            return C1173v.m();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Gson gson2 = gson;
            List listM = (List) gson2.fromJson(gson2.toJson(raw), new TypeToken<List<? extends MusicSongItem>>() { // from class: com.stepos.ailauncher.migu.card.MusicListCardProvider$parseItems$1$1
            }.getType());
            if (listM == null) {
                listM = C1173v.m();
            }
            objB = Result.b(listM);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            b.INSTANCE.h("provider.music.parseItems.fail", j.a("exception", thE.getClass().getSimpleName()), j.a("message", thE.getMessage()));
        }
        List listM2 = C1173v.m();
        if (Result.g(objB)) {
            objB = listM2;
        }
        return (List) objB;
    }
}
