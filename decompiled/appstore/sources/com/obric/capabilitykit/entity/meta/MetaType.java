package com.obric.capabilitykit.entity.meta;

import androidx.annotation.Keep;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.k0;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0002R%\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaType;", "", "()V", "ADDRESS", "", "ANNIVERSARY", "APP", "BANKCARD", "BOOK_NAME", "CREDENTIAL_NUMBER", "EMAIL_ADDRESS", "FLIGHT_NUMBER", "IDENTIFY_CARD_NUMBER", "INSTANT_MESSAGING", "LOCATION", "PERSON_NAME", "RELATIONSHIP", "TELEPHONE", "TEXT", "TIME", "TRACKING_NUMBER", "URL", "VERIFICATION_CODE", "_MEDIA", "get_MEDIA$annotations", "classMap", "", "Ljava/lang/Class;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "getClassMap", "()Ljava/util/Map;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaType {
    public static final int ADDRESS = 10001;
    public static final int ANNIVERSARY = 10002;
    public static final int APP = 10003;
    public static final int BANKCARD = 10004;
    public static final int BOOK_NAME = 10005;
    public static final int CREDENTIAL_NUMBER = 10016;
    public static final int EMAIL_ADDRESS = 10006;
    public static final int FLIGHT_NUMBER = 10007;
    public static final int IDENTIFY_CARD_NUMBER = 10008;

    @NotNull
    public static final MetaType INSTANCE = null;
    public static final int INSTANT_MESSAGING = 10018;
    public static final int LOCATION = 10020;
    public static final int PERSON_NAME = 10009;
    public static final int RELATIONSHIP = 10017;
    public static final int TELEPHONE = 10010;
    public static final int TEXT = 10011;
    public static final int TIME = 10012;
    public static final int TRACKING_NUMBER = 10013;
    public static final int URL = 10014;
    public static final int VERIFICATION_CODE = 10019;
    public static final int _MEDIA = 10015;

    @NotNull
    private static final Map<Integer, Class<? extends MetaValue>> classMap = null;

    static {
        INSTANCE = new MetaType();
        classMap = k0.j(new Pair[]{d.a(10001, MetaAddress.class), d.a(10002, MetaAnniversary.class), d.a(10003, MetaApp.class), d.a(10004, MetaBankCard.class), d.a(10005, MetaBookName.class), d.a(10006, MetaEmailAddress.class), d.a(Integer.valueOf(FLIGHT_NUMBER), MetaFlightNumber.class), d.a(Integer.valueOf(IDENTIFY_CARD_NUMBER), MetaIdentityCard.class), d.a(Integer.valueOf(PERSON_NAME), MetaPersonName.class), d.a(Integer.valueOf(TELEPHONE), MetaTelephone.class), d.a(Integer.valueOf(TEXT), MetaText.class), d.a(Integer.valueOf(TIME), MetaTime.class), d.a(Integer.valueOf(TRACKING_NUMBER), MetaTrackingNumber.class), d.a(Integer.valueOf(URL), MetaUrl.class), d.a(Integer.valueOf(CREDENTIAL_NUMBER), MetaCredentialNumber.class), d.a(Integer.valueOf(RELATIONSHIP), MetaRelationship.class), d.a(Integer.valueOf(INSTANT_MESSAGING), MetaInstantMessaging.class), d.a(Integer.valueOf(VERIFICATION_CODE), MetaVerificationCode.class)});
    }

    private MetaType() {
    }

    @Deprecated(message = "not used")
    public static /* synthetic */ void get_MEDIA$annotations() {
    }

    @NotNull
    public final Map<Integer, Class<? extends MetaValue>> getClassMap() {
        return classMap;
    }
}
