package com.stepos.ailauncher.floatcard.api;

import E4.FloatCardContent;
import E4.FloatCardRequest;
import E4.r;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H&¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\fH&¢\u0006\u0004\b%\u0010&J)\u0010)\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010'\u001a\u00020\f2\b\b\u0002\u0010(\u001a\u00020\u001fH&¢\u0006\u0004\b)\u0010*¨\u0006+À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/floatcard/api/IFloatCardService;", "", "LE4/r;", "host", "LY8/t;", "registerHost", "(LE4/r;)V", "unregisterHost", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardProvider;", Const.JSON_KEY_PROVIDER, "registerProvider", "(Lcom/stepos/ailauncher/floatcard/api/IFloatCardProvider;)V", "", "type", "unregisterProvider", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "handler", "registerEventHandler", "(Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;)V", "businessType", "unregisterEventHandler", "LE4/k;", "request", "show", "(LE4/k;)V", "cardId", "LE4/c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, a.BUTTON_UPDATE, "(Ljava/lang/String;LE4/c;)V", "", "animated", DidiCardProvider.ACTION_DISMISS, "(Ljava/lang/String;Z)V", "dismissAll", "()V", "hostIdOf", "(Ljava/lang/String;)Ljava/lang/String;", "text", "isFinal", "pushVoiceText", "(Ljava/lang/String;Ljava/lang/String;Z)V", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IFloatCardService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void dismiss$default(IFloatCardService iFloatCardService, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismiss");
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        iFloatCardService.dismiss(str, z10);
    }

    static /* synthetic */ void pushVoiceText$default(IFloatCardService iFloatCardService, String str, String str2, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pushVoiceText");
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        iFloatCardService.pushVoiceText(str, str2, z10);
    }

    void dismiss(String cardId, boolean animated);

    void dismissAll();

    String hostIdOf(String cardId);

    void pushVoiceText(String cardId, String text, boolean isFinal);

    void registerEventHandler(IFloatCardEventHandler handler);

    void registerHost(r host);

    void registerProvider(IFloatCardProvider provider);

    void show(FloatCardRequest request);

    void unregisterEventHandler(String businessType);

    void unregisterHost(r host);

    void unregisterProvider(String type);

    void update(String cardId, FloatCardContent content);
}
