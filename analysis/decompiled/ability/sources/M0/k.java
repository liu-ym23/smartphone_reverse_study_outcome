package M0;

import F9.InterfaceC0229g;
import F9.M;
import F9.s;
import F9.t;
import X6.m;
import X6.n;
import X6.o;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import a7.AbstractC0308d;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Base64;
import c7.C0881a;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.protobuf.AbstractC0916a;
import com.google.protobuf.AbstractC0924c;
import com.google.protobuf.AbstractC0926c1;
import com.google.protobuf.D0;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InterfaceC0938f1;
import com.stepos.ability.mcpserver.model.McpServerConfig;
import com.stepos.ability.voicewakeup.training.AudioFocusGateway;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.model.object.DefaultPreSignedPolicyURLGenerator;
import com.volcengine.tos.model.object.PolicySignatureCondition;
import com.volcengine.tos.model.object.PreSignedPolicyURLInput;
import com.volcengine.tos.model.object.PreSignedPolicyURLOutput;
import com.volcengine.tos.model.object.PreSignedURLInput;
import com.volcengine.tos.model.object.PreSignedURLOutput;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.stream.Collectors;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import k4.w;
import qa.InterfaceC1855g;
import qa.U;
import qa.v;
import z7.AbstractC2188i;
import z7.C2184e;

/* loaded from: classes2.dex */
public final class k implements AudioFocusGateway, InterfaceC0938f1, InterfaceC0229g, s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f958a;
    public Object b;
    public Object c;

    public /* synthetic */ k(int i) {
        this.f958a = i;
    }

    public static byte[] m(Context context, String str, int i) {
        W5.c.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.simple_crypto_AES");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.simple_crypto_AES", 0);
        W5.c.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.simple_crypto_AES structure complete");
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            byte[] bArrDecode = Base64.decode(string, 2);
            if (bArrDecode.length == i) {
                return bArrDecode;
            }
        }
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        sharedPreferences.edit().putString(str, Base64.encodeToString(bArr, 2)).commit();
        return bArr;
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public Object a(GeneratedMessageV3 generatedMessageV3) {
        D0 d02 = (D0) this.b;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < generatedMessageV3.z(d02.b.e).x().size(); i++) {
            arrayList.add(generatedMessageV3.z(d02.b.e).x().get(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.stepos.ability.voicewakeup.training.AudioFocusGateway
    public int abandonFocus() {
        return ((AudioManager) this.b).abandonAudioFocusRequest((AudioFocusRequest) this.c);
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public boolean b(GeneratedMessageV3 generatedMessageV3) {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public Object c(AbstractC0926c1 abstractC0926c1) {
        D0 d02 = (D0) this.b;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < abstractC0926c1.G(d02.b.e).x().size(); i++) {
            arrayList.add(abstractC0926c1.G(d02.b.e).x().get(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public boolean d(AbstractC0926c1 abstractC0926c1) {
        throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public void e(AbstractC0926c1 abstractC0926c1, Object obj) {
        abstractC0926c1.H(((D0) this.b).b.e).A().clear();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            g(abstractC0926c1, it.next());
        }
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public AbstractC0916a f(AbstractC0926c1 abstractC0926c1) {
        throw new UnsupportedOperationException("Nested builder not supported for map fields.");
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public void g(AbstractC0926c1 abstractC0926c1, Object obj) {
        List listA = abstractC0926c1.H(((D0) this.b).b.e).A();
        AbstractC0924c abstractC0924cK = (AbstractC0924c) obj;
        AbstractC0924c abstractC0924c = (AbstractC0924c) this.c;
        if (abstractC0924cK == null) {
            abstractC0924cK = null;
        } else if (!abstractC0924c.getClass().isInstance(abstractC0924cK)) {
            abstractC0924cK = abstractC0924c.toBuilder().t(abstractC0924cK).k();
        }
        listA.add(abstractC0924cK);
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public AbstractC0916a h() {
        return ((AbstractC0924c) this.c).q();
    }

    @Override // F9.s
    public t i(J9.i iVar) {
        return new y5.e((S7.k) this.b, (String) this.c);
    }

    @Override // F9.InterfaceC0229g
    public void j(J9.i iVar, IOException iOException) {
        try {
            ((InterfaceC1855g) this.b).r((v) this.c, iOException);
        } catch (Throwable th) {
            U.o(th);
            th.printStackTrace();
        }
    }

    @Override // F9.InterfaceC0229g
    public void k(J9.i iVar, M m) {
        InterfaceC1855g interfaceC1855g = (InterfaceC1855g) this.b;
        v vVar = (v) this.c;
        try {
            try {
                interfaceC1855g.j(vVar, vVar.c(m));
            } catch (Throwable th) {
                U.o(th);
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            U.o(th2);
            try {
                interfaceC1855g.r(vVar, th2);
            } catch (Throwable th3) {
                U.o(th3);
                th3.printStackTrace();
            }
        }
    }

    public SecretKeySpec l() {
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec("262t1#x23&^ya1bk".toCharArray(), (byte[]) this.b, 100, 256)).getEncoded(), "AES");
        } catch (Exception e) {
            throw new RuntimeException("Deal with exceptions properly!", e);
        }
    }

    public void n() throws Exception {
        File file;
        ArrayList arrayList = (ArrayList) this.c;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2184e c2184e = (C2184e) it.next();
            try {
                AbstractC2188i.d(c2184e.b);
                file = c2184e.f6977a;
            } catch (Exception e) {
                AbstractC2188i.i.log(Level.WARNING, "could not delete file ", (Throwable) e);
            }
            if (!file.delete()) {
                throw new Exception("could not delete temporary file: " + file.getAbsolutePath());
            }
        }
        arrayList.clear();
    }

    public PreSignedPolicyURLOutput o(PreSignedPolicyURLInput preSignedPolicyURLInput) {
        S6.a aVarA;
        String str;
        S6.b bVar;
        AbstractC0307c.a(preSignedPolicyURLInput, "PreSingedPolicyURLInput");
        AbstractC0307c.b(preSignedPolicyURLInput.getBucket());
        byte[] bArrB = null;
        if (preSignedPolicyURLInput.getConditions() == null || preSignedPolicyURLInput.getConditions().size() == 0) {
            throw new TosClientException("empty PolicySignatureConditions", null);
        }
        Iterator<PolicySignatureCondition> it = preSignedPolicyURLInput.getConditions().iterator();
        while (it.hasNext()) {
            if (!AbstractC0291a.s(it.next().getKey(), "key")) {
                throw new TosClientException("invalid pre signed url conditions, condition key should be 'key'", null);
            }
        }
        long jH = a7.f.h(preSignedPolicyURLInput.getExpires());
        OffsetDateTime offsetDateTimeAtOffset = Instant.now().atOffset(ZoneOffset.UTC);
        String str2 = offsetDateTimeAtOffset.format(a7.e.b);
        String str3 = offsetDateTimeAtOffset.format(a7.e.f1650a);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AbstractMap.SimpleEntry("X-Tos-Algorithm", "TOS4-HMAC-SHA256"));
        arrayList.add(new AbstractMap.SimpleEntry("X-Tos-Date", str2));
        arrayList.add(new AbstractMap.SimpleEntry("X-Tos-Expires", String.valueOf(jH)));
        K1.a aVar = (K1.a) this.c;
        if (aVar == null || (bVar = (S6.b) aVar.f903a) == null) {
            aVarA = null;
            str = null;
        } else {
            aVarA = ((S6.a) bVar).a();
            str = (String) ((K1.a) this.c).b;
        }
        if (aVarA != null) {
            String str4 = aVarA.d;
            if (str != null) {
                arrayList.add(new AbstractMap.SimpleEntry("X-Tos-Credential", aVarA.b + "/" + str3 + "/" + str + "/tos/request"));
                if (AbstractC0291a.y(str4)) {
                    arrayList.add(new AbstractMap.SimpleEntry("X-Tos-Security-Token", str4));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(preSignedPolicyURLInput.getConditions());
        arrayList2.add(new PolicySignatureCondition().setKey("bucket").setValue(preSignedPolicyURLInput.getBucket()));
        Q.a aVar2 = new Q.a(5);
        aVar2.b = arrayList2;
        arrayList.add(new AbstractMap.SimpleEntry("X-Tos-Policy", AbstractC0291a.I(new ByteArrayInputStream(C0881a.c((byte[]) AbstractC0308d.c(aVar2).c)), "policyInByte")));
        String strValueOf = String.valueOf(a7.e.d(a7.e.c(a7.e.a(arrayList) + "\nUNSIGNED-PAYLOAD")));
        StringBuilder sb = new StringBuilder("TOS4-HMAC-SHA256\n");
        sb.append(str2);
        sb.append('\n');
        sb.append(str3);
        sb.append(JsonPointer.SEPARATOR);
        String strJ = androidx.constraintlayout.core.dsl.a.j(sb, str, "/tos/request\n", strValueOf);
        if (aVarA != null && str != null) {
            String str5 = aVarA.c;
            Charset charset = StandardCharsets.UTF_8;
            bArrB = a7.e.b(a7.e.b(a7.e.b(a7.e.b(str5.getBytes(charset), str3.getBytes(charset)), str.getBytes(charset)), "tos".getBytes(charset)), "request".getBytes(charset));
        }
        arrayList.add(new AbstractMap.SimpleEntry("X-Tos-Signature", String.valueOf(a7.e.d(a7.e.b(bArrB, strJ.getBytes())))));
        String strA = a7.e.a(arrayList);
        o oVar = (o) this.b;
        String str6 = oVar.b;
        String str7 = oVar.c;
        if (AbstractC0291a.y(preSignedPolicyURLInput.getAlternativeEndpoint())) {
            str7 = (String) AbstractC0307c.d(preSignedPolicyURLInput.getAlternativeEndpoint()).get(1);
        }
        return new PreSignedPolicyURLOutput().setPreSignedPolicyURLGenerator(new DefaultPreSignedPolicyURLGenerator().setScheme(str6).setSignatureQuery(strA).setCustomDomain(preSignedPolicyURLInput.isCustomDomain()).setBucket(preSignedPolicyURLInput.getBucket()).setHost(str7)).setScheme(str6).setHost(str7).setSignatureQuery(strA);
    }

    public PreSignedURLOutput p(PreSignedURLInput preSignedURLInput) {
        AbstractC0307c.a(preSignedURLInput, "PreSignedURLInput");
        ((o) this.b).getClass();
        boolean zBooleanValue = preSignedURLInput.isCustomDomain() != null ? preSignedURLInput.isCustomDomain().booleanValue() : false;
        if (!zBooleanValue) {
            AbstractC0307c.b(preSignedURLInput.getBucket());
        }
        String httpMethod = preSignedURLInput.getHttpMethod();
        AbstractC0307c.a(httpMethod, "HttpMethod");
        if (!httpMethod.equals("GET") && !httpMethod.equals("PUT") && !httpMethod.equals("POST") && !httpMethod.equals("HEAD") && !httpMethod.equals("DELETE")) {
            throw new TosClientException("method input is invalid", null);
        }
        long jH = a7.f.h(preSignedURLInput.getExpires());
        String key = preSignedURLInput.getKey();
        if (AbstractC0291a.x(key)) {
            key = "";
        }
        X6.c cVarC = ((o) this.b).c(preSignedURLInput.getBucket(), key, preSignedURLInput.getHeader());
        cVarC.g = zBooleanValue ? 2 : 0;
        if (AbstractC0291a.y(preSignedURLInput.getAlternativeEndpoint())) {
            cVarC.c = (String) AbstractC0307c.d(preSignedURLInput.getAlternativeEndpoint()).get(1);
        }
        if (preSignedURLInput.getQuery() != null) {
            preSignedURLInput.getQuery().forEach(new m(cVarC, 0));
        }
        o oVar = (o) this.b;
        String httpMethod2 = preSignedURLInput.getHttpMethod();
        oVar.getClass();
        n nVarB = cVarC.b(null, httpMethod2);
        HashMap map = nVarB.m;
        K1.a aVar = cVarC.f1506a;
        if (aVar != null) {
            Duration durationOfSeconds = Duration.ofSeconds(jH);
            ((C3.a) aVar.e).getClass();
            OffsetDateTime offsetDateTimeAtOffset = Instant.now().atOffset(ZoneOffset.UTC);
            String str = offsetDateTimeAtOffset.format(a7.e.b);
            HashMap map2 = nVarB.n;
            HashMap map3 = new HashMap();
            S6.a aVarA = ((S6.a) ((S6.b) aVar.f903a)).a();
            String str2 = aVarA.b + "/" + offsetDateTimeAtOffset.format(a7.e.f1650a) + "/" + ((String) aVar.b) + "/tos/request";
            map3.put("X-Tos-Algorithm", "TOS4-HMAC-SHA256");
            map3.put("X-Tos-Credential", str2);
            map3.put("X-Tos-Date", str);
            map3.put("X-Tos-Expires", String.valueOf(durationOfSeconds.toMillis() / 1000));
            String str3 = aVarA.d;
            if (AbstractC0291a.y(str3)) {
                map3.put("X-Tos-Security-Token", str3);
            }
            ArrayList arrayListP = aVar.p(map, true);
            String str4 = nVarB.c;
            if (AbstractC0291a.x(str4)) {
                throw new TosClientException("empty host", null);
            }
            arrayListP.add(new AbstractMap.SimpleEntry("host", str4));
            Collections.sort(arrayListP, new M.d(3));
            map3.put("X-Tos-SignedHeaders", (String) arrayListP.stream().map(new E3.d(2)).sorted().collect(Collectors.joining(";")));
            ArrayList arrayList = new ArrayList(10);
            if (map2 != null) {
                map2.forEach(new S6.d(aVar, arrayList, 0));
            }
            map3.forEach(new S6.d(aVar, arrayList, 1));
            map3.put("X-Tos-Signature", aVar.e(nVarB.b, nVarB.d, "UNSIGNED-PAYLOAD", arrayListP, arrayList, offsetDateTimeAtOffset, aVarA));
            if (nVarB.n == null) {
                nVarB.n = new HashMap();
            }
            for (String str5 : map3.keySet()) {
                nVarB.n.put(str5, map3.get(str5));
            }
        }
        return new PreSignedURLOutput(nVarB.a().i, map);
    }

    public void q(za.i taskInfo) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        stepai.aios.guiagent.pipeline.b bVar = (stepai.aios.guiagent.pipeline.b) this.b;
        Aa.d dVar = (Aa.d) this.c;
        bVar.getClass();
        dVar.getClass();
        dVar.b = taskInfo;
        bVar.c.c(taskInfo);
    }

    @Override // com.stepos.ability.voicewakeup.training.AudioFocusGateway
    public int requestFocus() {
        return ((AudioManager) this.b).requestAudioFocus((AudioFocusRequest) this.c);
    }

    public String toString() {
        switch (this.f958a) {
            case 5:
                StringBuilder sb = new StringBuilder("PostPolicyJson{conditions=");
                sb.append((ArrayList) this.b);
                sb.append(", expiration='");
                return B7.a.q(sb, (String) this.c, "'}");
            default:
                return super.toString();
        }
    }

    public /* synthetic */ k(int i, Object obj, Object obj2) {
        this.f958a = i;
        this.c = obj;
        this.b = obj2;
    }

    public k(String str, String str2) {
        this.f958a = 8;
        if (str2 != null) {
            this.b = str;
            this.c = str2;
            return;
        }
        throw new NullPointerException("Suffix must be provided.");
    }

    public k(McpServerConfig config) {
        this.f958a = 7;
        kotlin.jvm.internal.k.f(config, "config");
        int verifyMaxConcurrent = config.getVerifyMaxConcurrent();
        int verifyRatePerMinute = config.getVerifyRatePerMinute();
        int verifyBurst = config.getVerifyBurst();
        this.b = new Semaphore(verifyMaxConcurrent);
        this.c = new w(new McpServerConfig(null, 0, 0, 0, 0, 0, verifyRatePerMinute, verifyBurst, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L, 0, 0, 0, 0, 0, 8388415, null));
    }

    public k(Context context) {
        this.f958a = 2;
        this.b = (AudioManager) context.getSystemService(AudioManager.class);
        this.c = new AudioFocusRequest.Builder(4).setAudioAttributes(new AudioAttributes.Builder().setUsage(16).setContentType(1).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(new H4.a()).build();
    }

    public k(S7.k kVar, String traceIdHeader) {
        this.f958a = 11;
        kotlin.jvm.internal.k.f(traceIdHeader, "traceIdHeader");
        this.b = kVar;
        this.c = traceIdHeader;
    }

    public k() {
        this.f958a = 12;
        File file = new File(System.getProperty("java.io.tmpdir"));
        this.b = file;
        if (!file.exists()) {
            file.mkdirs();
        }
        this.c = new ArrayList();
    }

    public k(stepai.aios.guiagent.pipeline.b bVar, Aa.d dVar) {
        this.f958a = 1;
        this.b = bVar;
        this.c = dVar;
    }

    public k(D0 d02, Class cls) {
        this.f958a = 6;
        this.b = d02;
        this.c = ((GeneratedMessageV3) GeneratedMessageV3.u(GeneratedMessageV3.t(cls, "getDefaultInstance", new Class[0]), null, new Object[0])).z(d02.b.e).y();
    }
}
