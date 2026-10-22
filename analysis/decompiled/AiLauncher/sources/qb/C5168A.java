package qb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lqb/A;", "Lqb/F;", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "", "c", "()Z", "isString", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l(with = C5169B.class)
/* renamed from: qb.A, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5168A extends F {
    public static final C5168A INSTANCE = new C5168A();
    private static final String content = "null";

    public C5168A() {
        super(null);
    }

    @Override // qb.F
    /* renamed from: b */
    public String getContent() {
        return content;
    }

    @Override // qb.F
    /* renamed from: c */
    public boolean getIsString() {
        return false;
    }

    public final KSerializer<C5168A> serializer() {
        return C5169B.f38620a;
    }
}
