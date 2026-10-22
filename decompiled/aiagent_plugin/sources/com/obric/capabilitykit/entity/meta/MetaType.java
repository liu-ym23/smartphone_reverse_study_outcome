package com.obric.capabilitykit.entity.meta;

import d.a.ao;
import d.m;
import d.s;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaType {
    public static final int ADDRESS = 10001;
    public static final int ANNIVERSARY = 10002;
    public static final int APP = 10003;
    public static final int Artist = 10021;
    public static final int BANKCARD = 10004;
    public static final int BOOK_NAME = 10005;
    public static final int CREDENTIAL_NUMBER = 10016;
    public static final int Cover = 10022;
    public static final int EMAIL_ADDRESS = 10006;
    public static final int FLIGHT_NUMBER = 10007;
    public static final int IDENTIFY_CARD_NUMBER = 10008;
    public static final MetaType INSTANCE = null;
    public static final int INSTANT_MESSAGING = 10018;
    public static final int LOCATION = 10020;
    public static final int PERSON_NAME = 10009;
    public static final int Preview = 10023;
    public static final int RELATIONSHIP = 10017;
    public static final int TELEPHONE = 10010;
    public static final int TEXT = 10011;
    public static final int TIME = 10012;
    public static final int TRACKING_NUMBER = 10013;
    public static final int URL = 10014;
    public static final int VERIFICATION_CODE = 10019;
    public static final int _MEDIA = 10015;
    private static final Map<Integer, Class<? extends MetaValue>> classMap = null;

    static {
        INSTANCE = new MetaType();
        classMap = ao.a(new m[]{s.a(10001, MetaAddress.class), s.a(10002, MetaAnniversary.class), s.a(10003, MetaApp.class), s.a(10004, MetaBankCard.class), s.a(10005, MetaBookName.class), s.a(10006, MetaEmailAddress.class), s.a(Integer.valueOf(FLIGHT_NUMBER), MetaFlightNumber.class), s.a(Integer.valueOf(IDENTIFY_CARD_NUMBER), MetaIdentityCard.class), s.a(Integer.valueOf(PERSON_NAME), MetaPersonName.class), s.a(Integer.valueOf(TELEPHONE), MetaTelephone.class), s.a(Integer.valueOf(TEXT), MetaText.class), s.a(Integer.valueOf(TIME), MetaTime.class), s.a(Integer.valueOf(TRACKING_NUMBER), MetaTrackingNumber.class), s.a(Integer.valueOf(URL), MetaUrl.class), s.a(Integer.valueOf(CREDENTIAL_NUMBER), MetaCredentialNumber.class), s.a(Integer.valueOf(RELATIONSHIP), MetaRelationship.class), s.a(Integer.valueOf(INSTANT_MESSAGING), MetaInstantMessaging.class), s.a(Integer.valueOf(VERIFICATION_CODE), MetaVerificationCode.class)});
    }

    private MetaType() {
    }

    public static /* synthetic */ void get_MEDIA$annotations() {
    }

    public final Map<Integer, Class<? extends MetaValue>> getClassMap() {
        return classMap;
    }
}
