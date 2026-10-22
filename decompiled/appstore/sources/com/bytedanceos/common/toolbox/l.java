package com.bytedanceos.common.toolbox;

import android.util.SparseIntArray;
import com.bytedanceos.common.R$string;
import com.obric.capabilitykit.entity.app.EntityType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f10067a = null;

    static {
        SparseIntArray r10 = new SparseIntArray();
        f10067a = r10;
        r10.put(0, R$string.UNKOWN_ERROR);
        r10.put(-1, R$string.CONNECTION_EXCEPTION);
        r10.put(-2, R$string.SOCKET_TIME_OUT);
        r10.put(-3, R$string.CONNECT_TIME_OUT);
        r10.put(-4, R$string.CERTIFICATE_EXPIRED);
        r10.put(-7, R$string.EXECUTION_TIME_OUT);
        r10.put(500, R$string.HTTP_SERVER_ERROR);
        r10.put(900, R$string.SERVER_SAFEGUARD);
        r10.put(800, R$string.CLIENT_VERSION_LOW);
        r10.put(1001, R$string.REQUEST_ERROR_DATA_FORMAT);
        r10.put(1002, R$string.REQUEST_ERROR_PARAMETER);
        r10.put(1003, R$string.REQUEST_ERROR_METHOD_URL);
        r10.put(1010, R$string.FORBIDDEN);
        r10.put(EntityType.STOCK, R$string.INVALID_UID_FORMAT);
        r10.put(1102, R$string.INVALID_PASSWORD_FORMAT);
        r10.put(1103, R$string.INVALID_AVATAR_FORMAT);
        r10.put(1104, R$string.INVALID_QUESTION_FORMAT);
        r10.put(1105, R$string.INVALID_ANSWER_FORMAT);
        r10.put(1106, R$string.NO_ACCOUNT_RECORD);
        r10.put(1107, R$string.PASSWORD_ERROR);
        r10.put(1108, R$string.ANSWER_ERROR);
        r10.put(1109, R$string.NEED_ALIAS);
        r10.put(EntityType.IM_CONTACT, R$string.INVALID_ALIAS_FORMAT);
        r10.put(1202, R$string.NO_ACCOUNT_ALIAS);
        r10.put(1203, R$string.ALIAS_IS_REGIESTERED);
        r10.put(1204, R$string.INVALID_PHONE_FORMAT);
        r10.put(1205, R$string.valid_phone_number);
        r10.put(1206, R$string.PHONE_IS_REGIESTERED);
        r10.put(1207, R$string.INVALID_EMAIL_FORMAT);
        r10.put(1208, R$string.valid_email);
        r10.put(1209, R$string.EMAIL_IS_REGISTERED);
        r10.put(1210, R$string.INVALID_NICKNAME_FORMAT);
        r10.put(1211, R$string.NICKNAME_IS_NOT_REGISTERED);
        r10.put(1212, R$string.NICKNAME_IS_REGIESTERED);
        r10.put(1213, R$string.NICKNAME_HAS_SENSITIVE_WORDS);
        int r11 = R$string.valid_verify_code;
        r10.put(EntityType.DOUBAO_ACCOUNT, r11);
        r10.put(1302, r11);
        r10.put(1303, R$string.need_refresh_verify_code);
        r10.put(1304, R$string.REQUEST_MORE_FREQUENTLY);
        r10.put(EntityType.LIFE_LOG, R$string.INVALID_ERROR_TOKEN_FORMAT);
        r10.put(1402, R$string.TOKEN_ERROR);
        r10.put(EntityType.USER_PROFILE, R$string.LOGIN_FAILED_REQUENTLY);
        r10.put(1502, R$string.need_verify_code);
        r10.put(EntityType.EVENT_TASK, R$string.INVALID_ERROR_TICKET_FORMAT);
        r10.put(1602, R$string.TICKET_IS_INVALIDED);
        r10.put(EntityType.APP_INFO, R$string.TICKET_IS_LOGOUT);
        r10.put(1000000, R$string.ERROR_SERVICE_SYSTEM_WRONG);
        r10.put(1000001, R$string.ERROR_SERVICE_OPERATION_WRONG);
        r10.put(1000002, R$string.ERROR_SERVICE_LOST_PARAMETER);
        r10.put(1000003, R$string.ERROR_SERVICE_APP_INVALID);
        r10.put(1000004, R$string.ERROR_SERVICE_USER_INVALID);
        r10.put(1000005, R$string.ERROR_SERVICE_DOWNLOAD_INVALID);
        r10.put(1002001, R$string.ERROR_CATEGORY_ID_INVALID);
        r10.put(1004001, R$string.ERROR_TOPIC_ID_INVALID);
        r10.put(1006001, R$string.ERROR_APP_ID_INVALID);
        r10.put(1006002, R$string.ERROR_APP_PACKAGENAME_INVALID);
        r10.put(1008001, R$string.ERROR_COMMENTS_TOO_LONG);
        r10.put(1008002, R$string.ERROR_COMMENTS_TOO_FREQUENTLY);
        r10.put(1008003, R$string.ERROR_COMMENTS_HAS_SENSITIVE_WORDS);
        r10.put(1008004, R$string.ERROR_COMMENTS_SET_NICKNAME);
        r10.put(1009001, R$string.ERROR_SEARCH_WORD_INVALID);
    }
}
