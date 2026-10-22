package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class TransJavirsActionInfo extends f {
    public static final int JAVIRS_ACTION_ID_FIELD_NUMBER = 4;
    public static final int JAVIRS_ACTION_MODE_FIELD_NUMBER = 2;
    public static final int JAVIRS_CAN_DISPLAY_FIELD_NUMBER = 8;
    public static final int JAVIRS_CAN_INTERRUPT_FIELD_NUMBER = 7;
    public static final int JAVIRS_SCENE_FIELD_NUMBER = 6;
    public static final int JAVIRS_TEXT_FIELD_NUMBER = 1;
    public static final int JAVIRS_VOICE_TYPE_FIELD_NUMBER = 3;
    public static final int VOICE_TEXT_ALL_FIELD_NUMBER = 5;
    private int cachedSize;
    private boolean hasJavirsActionId;
    private boolean hasJavirsActionMode;
    private boolean hasJavirsCanDisplay;
    private boolean hasJavirsCanInterrupt;
    private boolean hasJavirsScene;
    private boolean hasJavirsText;
    private boolean hasJavirsVoiceType;
    private boolean hasVoiceTextAll;
    private int javirsActionId_;
    private a javirsActionMode_;
    private boolean javirsCanDisplay_;
    private boolean javirsCanInterrupt_;
    private a javirsScene_;
    private a javirsText_;
    private int javirsVoiceType_;
    private a voiceTextAll_;

    public TransJavirsActionInfo() {
        a aVar = a.f1216c;
        this.javirsText_ = aVar;
        this.javirsActionMode_ = aVar;
        this.javirsVoiceType_ = 0;
        this.javirsActionId_ = 0;
        this.voiceTextAll_ = aVar;
        this.javirsScene_ = aVar;
        this.javirsCanInterrupt_ = false;
        this.javirsCanDisplay_ = false;
        this.cachedSize = -1;
    }

    public static TransJavirsActionInfo parseFrom(b bVar) throws IOException {
        return new TransJavirsActionInfo().mergeFrom(bVar);
    }

    public final TransJavirsActionInfo clear() {
        clearJavirsText();
        clearJavirsActionMode();
        clearJavirsVoiceType();
        clearJavirsActionId();
        clearVoiceTextAll();
        clearJavirsScene();
        clearJavirsCanInterrupt();
        clearJavirsCanDisplay();
        this.cachedSize = -1;
        return this;
    }

    public TransJavirsActionInfo clearJavirsActionId() {
        this.hasJavirsActionId = false;
        this.javirsActionId_ = 0;
        return this;
    }

    public TransJavirsActionInfo clearJavirsActionMode() {
        this.hasJavirsActionMode = false;
        this.javirsActionMode_ = a.f1216c;
        return this;
    }

    public TransJavirsActionInfo clearJavirsCanDisplay() {
        this.hasJavirsCanDisplay = false;
        this.javirsCanDisplay_ = false;
        return this;
    }

    public TransJavirsActionInfo clearJavirsCanInterrupt() {
        this.hasJavirsCanInterrupt = false;
        this.javirsCanInterrupt_ = false;
        return this;
    }

    public TransJavirsActionInfo clearJavirsScene() {
        this.hasJavirsScene = false;
        this.javirsScene_ = a.f1216c;
        return this;
    }

    public TransJavirsActionInfo clearJavirsText() {
        this.hasJavirsText = false;
        this.javirsText_ = a.f1216c;
        return this;
    }

    public TransJavirsActionInfo clearJavirsVoiceType() {
        this.hasJavirsVoiceType = false;
        this.javirsVoiceType_ = 0;
        return this;
    }

    public TransJavirsActionInfo clearVoiceTextAll() {
        this.hasVoiceTextAll = false;
        this.voiceTextAll_ = a.f1216c;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getJavirsActionId() {
        return this.javirsActionId_;
    }

    public a getJavirsActionMode() {
        return this.javirsActionMode_;
    }

    public boolean getJavirsCanDisplay() {
        return this.javirsCanDisplay_;
    }

    public boolean getJavirsCanInterrupt() {
        return this.javirsCanInterrupt_;
    }

    public a getJavirsScene() {
        return this.javirsScene_;
    }

    public a getJavirsText() {
        return this.javirsText_;
    }

    public int getJavirsVoiceType() {
        return this.javirsVoiceType_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iB = hasJavirsText() ? d.b(1, getJavirsText()) : 0;
        if (hasJavirsActionMode()) {
            iB += d.b(2, getJavirsActionMode());
        }
        if (hasJavirsVoiceType()) {
            iB += d.e(3, getJavirsVoiceType());
        }
        if (hasJavirsActionId()) {
            iB += d.e(4, getJavirsActionId());
        }
        if (hasVoiceTextAll()) {
            iB += d.b(5, getVoiceTextAll());
        }
        if (hasJavirsScene()) {
            iB += d.b(6, getJavirsScene());
        }
        if (hasJavirsCanInterrupt()) {
            getJavirsCanInterrupt();
            iB += d.a(7);
        }
        if (hasJavirsCanDisplay()) {
            getJavirsCanDisplay();
            iB += d.a(8);
        }
        this.cachedSize = iB;
        return iB;
    }

    public a getVoiceTextAll() {
        return this.voiceTextAll_;
    }

    public boolean hasJavirsActionId() {
        return this.hasJavirsActionId;
    }

    public boolean hasJavirsActionMode() {
        return this.hasJavirsActionMode;
    }

    public boolean hasJavirsCanDisplay() {
        return this.hasJavirsCanDisplay;
    }

    public boolean hasJavirsCanInterrupt() {
        return this.hasJavirsCanInterrupt;
    }

    public boolean hasJavirsScene() {
        return this.hasJavirsScene;
    }

    public boolean hasJavirsText() {
        return this.hasJavirsText;
    }

    public boolean hasJavirsVoiceType() {
        return this.hasJavirsVoiceType;
    }

    public boolean hasVoiceTextAll() {
        return this.hasVoiceTextAll;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TransJavirsActionInfo setJavirsActionId(int i4) {
        this.hasJavirsActionId = true;
        this.javirsActionId_ = i4;
        return this;
    }

    public TransJavirsActionInfo setJavirsActionMode(a aVar) {
        this.hasJavirsActionMode = true;
        this.javirsActionMode_ = aVar;
        return this;
    }

    public TransJavirsActionInfo setJavirsCanDisplay(boolean z4) {
        this.hasJavirsCanDisplay = true;
        this.javirsCanDisplay_ = z4;
        return this;
    }

    public TransJavirsActionInfo setJavirsCanInterrupt(boolean z4) {
        this.hasJavirsCanInterrupt = true;
        this.javirsCanInterrupt_ = z4;
        return this;
    }

    public TransJavirsActionInfo setJavirsScene(a aVar) {
        this.hasJavirsScene = true;
        this.javirsScene_ = aVar;
        return this;
    }

    public TransJavirsActionInfo setJavirsText(a aVar) {
        this.hasJavirsText = true;
        this.javirsText_ = aVar;
        return this;
    }

    public TransJavirsActionInfo setJavirsVoiceType(int i4) {
        this.hasJavirsVoiceType = true;
        this.javirsVoiceType_ = i4;
        return this;
    }

    public TransJavirsActionInfo setVoiceTextAll(a aVar) {
        this.hasVoiceTextAll = true;
        this.voiceTextAll_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasJavirsText()) {
            dVar.q(1, getJavirsText());
        }
        if (hasJavirsActionMode()) {
            dVar.q(2, getJavirsActionMode());
        }
        if (hasJavirsVoiceType()) {
            dVar.s(3, getJavirsVoiceType());
        }
        if (hasJavirsActionId()) {
            dVar.s(4, getJavirsActionId());
        }
        if (hasVoiceTextAll()) {
            dVar.q(5, getVoiceTextAll());
        }
        if (hasJavirsScene()) {
            dVar.q(6, getJavirsScene());
        }
        if (hasJavirsCanInterrupt()) {
            dVar.p(7, getJavirsCanInterrupt());
        }
        if (hasJavirsCanDisplay()) {
            dVar.p(8, getJavirsCanDisplay());
        }
    }

    public static TransJavirsActionInfo parseFrom(byte[] bArr) throws e {
        return (TransJavirsActionInfo) new TransJavirsActionInfo().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransJavirsActionInfo mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                setJavirsText(bVar.b());
            } else if (iO == 18) {
                setJavirsActionMode(bVar.b());
            } else if (iO == 24) {
                setJavirsVoiceType(bVar.k());
            } else if (iO == 32) {
                setJavirsActionId(bVar.k());
            } else if (iO == 42) {
                setVoiceTextAll(bVar.b());
            } else if (iO == 50) {
                setJavirsScene(bVar.b());
            } else if (iO == 56) {
                setJavirsCanInterrupt(bVar.a());
            } else if (iO == 64) {
                setJavirsCanDisplay(bVar.a());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
