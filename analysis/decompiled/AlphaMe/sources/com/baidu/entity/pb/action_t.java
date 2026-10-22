package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class action_t extends f {
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int TEXT_FIELD_NUMBER = 3;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int cachedSize;
    private boolean hasKey;
    private boolean hasText;
    private boolean hasValue;
    private int key_ = 0;
    private a text_;
    private a value_;

    public action_t() {
        a aVar = a.f1216c;
        this.value_ = aVar;
        this.text_ = aVar;
        this.cachedSize = -1;
    }

    public static action_t parseFrom(b bVar) throws IOException {
        return new action_t().mergeFrom(bVar);
    }

    public final action_t clear() {
        clearKey();
        clearValue();
        clearText();
        this.cachedSize = -1;
        return this;
    }

    public action_t clearKey() {
        this.hasKey = false;
        this.key_ = 0;
        return this;
    }

    public action_t clearText() {
        this.hasText = false;
        this.text_ = a.f1216c;
        return this;
    }

    public action_t clearValue() {
        this.hasValue = false;
        this.value_ = a.f1216c;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getKey() {
        return this.key_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasKey() ? d.e(1, getKey()) : 0;
        if (hasValue()) {
            iE += d.b(2, getValue());
        }
        if (hasText()) {
            iE += d.b(3, getText());
        }
        this.cachedSize = iE;
        return iE;
    }

    public a getText() {
        return this.text_;
    }

    public a getValue() {
        return this.value_;
    }

    public boolean hasKey() {
        return this.hasKey;
    }

    public boolean hasText() {
        return this.hasText;
    }

    public boolean hasValue() {
        return this.hasValue;
    }

    public final boolean isInitialized() {
        return true;
    }

    public action_t setKey(int i4) {
        this.hasKey = true;
        this.key_ = i4;
        return this;
    }

    public action_t setText(a aVar) {
        this.hasText = true;
        this.text_ = aVar;
        return this;
    }

    public action_t setValue(a aVar) {
        this.hasValue = true;
        this.value_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasKey()) {
            dVar.s(1, getKey());
        }
        if (hasValue()) {
            dVar.q(2, getValue());
        }
        if (hasText()) {
            dVar.q(3, getText());
        }
    }

    public static action_t parseFrom(byte[] bArr) throws e {
        return (action_t) new action_t().mergeFrom(bArr);
    }

    @Override // L1.f
    public action_t mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setKey(bVar.k());
            } else if (iO == 18) {
                setValue(bVar.b());
            } else if (iO == 26) {
                setText(bVar.b());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
