package com.bytedance.android.ec.base.api.ai.conversation;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/conversation/SchemaResolver;", "", "()V", "TAG", "", "parseAIParams", "Lcom/bytedance/android/ec/base/api/ai/conversation/AIChatSchemaParams;", "schema", "parseOriginBcmId", "uri", "Landroid/net/Uri;", "aiParamsJson", "Lorg/json/JSONObject;", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class SchemaResolver {
    public static final SchemaResolver INSTANCE = null;
    private static final String TAG = "ECSchemaResolver";

    private SchemaResolver() {
    }

    static {
        INSTANCE = new SchemaResolver();
    }

    @JvmStatic
    public static final AIChatSchemaParams parseAIParams(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L44
        String r103 = UriProtector.getQueryParameter(r102, ConversationConstants.KEY_AI_PARAMS);     // Catch: Throwable -> L44
        String r104 = null;
        if (r103 != null) goto L16;
    L28:
        JSONObject r105 = null;
    L29:
        if (r105 == null) goto L35;
        String r106 = r105.optString("conversation_id");     // Catch: Throwable -> L44
        if (r106 == null) goto L35;
        if ((!StringsKt.isBlank(r106)) == false) goto L35;
    L36:
        if (r105 == null) goto L42;
        String r107 = r105.optString(ConversationConstants.KEY_ORIGIN_MESSAGE_ID);     // Catch: Throwable -> L44
        if (r107 == null) goto L42;
        if ((true ^ StringsKt.isBlank(r107)) == false) goto L42;
        r104 = r107;
    L42:
        return new AIChatSchemaParams(r106, r104, INSTANCE.parseOriginBcmId(r102, r105));
    L35:
        r106 = null;
        goto L36
    L16:
        if ((!StringsKt.isBlank(r103)) == true) goto L19;
        r103 = null;
    L19:
        if (r103 == null) goto L28;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L22
        Object r109 = Result.m9449constructorimpl(new JSONObject(r103));     // Catch: Throwable -> L22
    L25:
        if (Result.m9455isFailureimpl(r109) == false) goto L27;
        r109 = null;
    L27:
        r105 = (JSONObject) r109;     // Catch: Throwable -> L44
    L22:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L44
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L44
    L45:
        return AIChatSchemaParams.EMPTY;
    L11:
        return AIChatSchemaParams.EMPTY;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    private final String parseOriginBcmId(Uri r100, JSONObject r101) {
        if (r101 == null) goto L12;
        String r102 = r101.optString(ConversationConstants.KEY_BCM_ID);
        if (r102 == null) goto L12;
        if ((!StringsKt.isBlank(r102)) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L12;
        return r102;
    L12:
        String r103 = UriProtector.getQueryParameter(r100, ConversationConstants.KEY_ECOM_SAAS_EXTRA);
        if (r103 != null) goto L15;
        return null;
    L15:
        if ((!StringsKt.isBlank(r103)) == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L37;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L21
        Object r105 = Result.m9449constructorimpl(new JSONObject(r103));     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r105) == false) goto L26;
        r105 = null;
    L26:
        JSONObject r106 = (JSONObject) r105;
        if (r106 == null) goto L38;
        String r107 = r106.optString(ConversationConstants.KEY_BCM_ID);
        if (r107 != null) goto L31;
        return null;
    L31:
        if ((!StringsKt.isBlank(r107)) == true) goto L33;
        return null;
    L33:
        return r107;
    L38:
        return null;
    L21:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L37:
        return null;
    }
}
