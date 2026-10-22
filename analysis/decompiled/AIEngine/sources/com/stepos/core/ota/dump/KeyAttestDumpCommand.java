package com.stepos.core.ota.dump;

import com.stepos.core.ota.crypto.attest.DeviceKeyProbe;
import e9.a;
import gc.o;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeyAttestDumpCommand {
    public static final KeyAttestDumpCommand INSTANCE = new KeyAttestDumpCommand();
    private static final long TIMEOUT_MS = 60000;

    private KeyAttestDumpCommand() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handle$lambda$3(PrintWriter printWriter, boolean z) {
        Object objA;
        try {
            DeviceKeyProbe.INSTANCE.dump(printWriter, z);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            printWriter.println("probe crashed: " + thB.getClass().getSimpleName() + ": " + thB.getMessage());
        }
        printWriter.flush();
    }

    public final void handle(List<String> args, PrintWriter writer) throws InterruptedException {
        g.f(args, "args");
        g.f(writer, "writer");
        boolean z = false;
        if (!args.isEmpty()) {
            Iterator<T> it = args.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (o.f0((String) it.next(), "certs")) {
                    z = true;
                    break;
                }
            }
        }
        StringWriter stringWriter = new StringWriter();
        Thread thread = new Thread(new a(z, 0, new PrintWriter(stringWriter)), "aiengine-keyattest");
        thread.setDaemon(true);
        thread.start();
        thread.join(60000L);
        writer.print(stringWriter.toString());
        if (thread.isAlive()) {
            writer.println();
            writer.println("!! probe still running after 60000ms — output above is partial");
        }
    }
}
