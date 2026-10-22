package a4;

/* loaded from: classes.dex */
public final class u extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(int i2) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        switch (i2) {
            case 4:
                break;
        }
    }
}
