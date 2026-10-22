package com.stepos.launcher.assistant.widget;

import android.os.Bundle;
import java.util.Optional;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public interface WidgetMetaDataParse {
    String getMetaKey();

    void handleMetaValue(String str);

    default void parse(Bundle bundle) {
        Optional.ofNullable(bundle.getString(getMetaKey(), null)).ifPresent(new Consumer() { // from class: com.stepos.launcher.assistant.widget.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f30173a.handleMetaValue((String) obj);
            }
        });
    }
}
