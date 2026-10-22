package qb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import rb.O;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u0017\u0010\f¨\u0006\u001d"}, d2 = {"Lqb/w;", "Lqb/F;", "", "body", "", "isString", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "coerceToInlineType", "<init>", "(Ljava/lang/Object;ZLkotlinx/serialization/descriptors/SerialDescriptor;)V", "", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Z", "c", "()Z", Const.INTENT_KEY_PKGNAME, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "e", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "Ljava/lang/String;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class w extends F {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean isString;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor coerceToInlineType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String content;

    public /* synthetic */ w(Object obj, boolean z10, SerialDescriptor serialDescriptor, int i10, kotlin.jvm.internal.i iVar) {
        this(obj, z10, (i10 & 4) != 0 ? null : serialDescriptor);
    }

    @Override // qb.F
    /* renamed from: b, reason: from getter */
    public String getContent() {
        return this.content;
    }

    @Override // qb.F
    /* renamed from: c, reason: from getter */
    public boolean getIsString() {
        return this.isString;
    }

    /* renamed from: e, reason: from getter */
    public final SerialDescriptor getCoerceToInlineType() {
        return this.coerceToInlineType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || w.class != other.getClass()) {
            return false;
        }
        w wVar = (w) other;
        return getIsString() == wVar.getIsString() && kotlin.jvm.internal.p.d(getContent(), wVar.getContent());
    }

    public int hashCode() {
        return (Boolean.hashCode(getIsString()) * 31) + getContent().hashCode();
    }

    @Override // qb.F
    public String toString() {
        if (!getIsString()) {
            return getContent();
        }
        StringBuilder sb2 = new StringBuilder();
        O.c(sb2, getContent());
        return sb2.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Object body, boolean z10, SerialDescriptor serialDescriptor) {
        super(null);
        kotlin.jvm.internal.p.i(body, "body");
        this.isString = z10;
        this.coerceToInlineType = serialDescriptor;
        this.content = body.toString();
        if (serialDescriptor != null && !serialDescriptor.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
