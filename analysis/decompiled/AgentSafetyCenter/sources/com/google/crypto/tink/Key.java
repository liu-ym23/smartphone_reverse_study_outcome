package com.google.crypto.tink;

import com.google.crypto.tink.annotations.Alpha;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public abstract class Key {
    public abstract boolean equalsKey(Key key);

    @Nullable
    public abstract Integer getIdRequirementOrNull();

    public abstract Parameters getParameters();
}
