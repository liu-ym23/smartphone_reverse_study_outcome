package com.google.crypto.tink.aead;

import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ChaCha20Poly1305Parameters extends AeadParameters {
    private final Variant variant;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Variant {
        private final String name;
        public static final Variant TINK = new Variant("TINK");
        public static final Variant CRUNCHY = new Variant("CRUNCHY");
        public static final Variant NO_PREFIX = new Variant("NO_PREFIX");

        private Variant(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    private ChaCha20Poly1305Parameters(Variant variant) {
        this.variant = variant;
    }

    public static ChaCha20Poly1305Parameters create() {
        return new ChaCha20Poly1305Parameters(Variant.NO_PREFIX);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ChaCha20Poly1305Parameters) && ((ChaCha20Poly1305Parameters) obj).getVariant() == getVariant();
    }

    public Variant getVariant() {
        return this.variant;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hashCode(this.variant);
    }

    public String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.variant + ")";
    }

    public static ChaCha20Poly1305Parameters create(Variant variant) {
        return new ChaCha20Poly1305Parameters(variant);
    }
}
