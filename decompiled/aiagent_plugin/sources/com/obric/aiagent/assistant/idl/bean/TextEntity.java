package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import com.obric.capabilitykit.entity.app.AppEntity;
import d.h.b.o;

/* JADX INFO: compiled from: TextEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextEntity extends AppEntity {
    private final String text;

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public TextEntity(String r9) {
        o.e(r9, "text");
        super("", 0, 0, 0);
        this.text = r9;
    }

    public final String getText() {
        return this.text;
    }
}
