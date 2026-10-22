package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/e;", "", "<init>", "()V", "", "x", "x1", "y1", "x2", "y2", Const.INTENT_KEY_PKGNAME, "(FFFFF)F", "t", "p1", "p2", Const.INTENT_KEY_APIKEY, "(FFF)F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.longpress.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3040e {
    public static final C3040e INSTANCE = new C3040e();

    public final float a(float t10, float p12, float p22) {
        float f10 = 1.0f - t10;
        float f11 = 3.0f * f10;
        return (f10 * f11 * t10 * p12) + (f11 * t10 * t10 * p22) + (t10 * t10 * t10);
    }

    public final float b(float x10, float x12, float y12, float x22, float y22) {
        float fM = C5685n.m(x10, 0.0f, 1.0f);
        if (fM == 0.0f || fM == 1.0f) {
            return fM;
        }
        float f10 = 0.0f;
        float f11 = 1.0f;
        for (int i10 = 0; i10 < 16; i10++) {
            float f12 = (f10 + f11) * 0.5f;
            if (INSTANCE.a(f12, x12, x22) < fM) {
                f10 = f12;
            } else {
                f11 = f12;
            }
        }
        return C5685n.m(a((f10 + f11) * 0.5f, y12, y22), 0.0f, 1.0f);
    }
}
