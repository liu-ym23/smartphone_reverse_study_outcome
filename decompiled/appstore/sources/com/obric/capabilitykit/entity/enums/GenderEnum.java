package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.u;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "MALE", "FEMALE", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum GenderEnum extends Enum<GenderEnum> {
    private static final /* synthetic */ GenderEnum[] $VALUES = null;

    @NotNull
    public static final a Companion = null;
    public static final GenderEnum FEMALE = null;
    public static final GenderEnum MALE = null;

    public static final class a {
        public a() {
        }

        public final GenderEnum a(String r10) {
            if (r10 == null) goto L11;
            return GenderEnum.valueOf(r10);
        L7:
            Log.w("EntityEnum", "failed to create enum from name " + r10 + " for enum type " + u.b(GenderEnum.class).getSimpleName() + TokenParser.SP);
            return null;
        L11:
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    private static final /* synthetic */ GenderEnum[] $values() {
        return new GenderEnum[]{MALE, FEMALE};
    }

    static {
        MALE = new GenderEnum("MALE", 0);
        FEMALE = new GenderEnum("FEMALE", 1);
        $VALUES = $values();
        Companion = new a(null);
    }

    private GenderEnum(String r10, int r11) {
        super(r10, r11);
    }

    public static GenderEnum valueOf(String r10) {
        return (GenderEnum) Enum.valueOf(GenderEnum.class, r10);
    }

    public static GenderEnum[] values() {
        return (GenderEnum[]) $VALUES.clone();
    }
}
