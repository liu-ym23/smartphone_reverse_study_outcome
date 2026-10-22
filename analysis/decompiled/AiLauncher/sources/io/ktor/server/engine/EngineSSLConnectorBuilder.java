package io.ktor.server.engine;

import java.io.File;
import java.security.KeyStore;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010\r\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R$\u0010(\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\"\u0010,\u001a\u00020+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00103\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u00069"}, d2 = {"Lio/ktor/server/engine/EngineSSLConnectorBuilder;", "Lio/ktor/server/engine/EngineConnectorBuilder;", "Lio/ktor/server/engine/EngineSSLConnectorConfig;", "Ljava/security/KeyStore;", "keyStore", "", "keyAlias", "Lkotlin/Function0;", "", "keyStorePassword", "privateKeyPassword", "<init>", "(Ljava/security/KeyStore;Ljava/lang/String;Lp9/a;Lp9/a;)V", "Ljava/security/KeyStore;", "getKeyStore", "()Ljava/security/KeyStore;", "setKeyStore", "(Ljava/security/KeyStore;)V", "Ljava/lang/String;", "getKeyAlias", "()Ljava/lang/String;", "setKeyAlias", "(Ljava/lang/String;)V", "Lp9/a;", "getKeyStorePassword", "()Lp9/a;", "setKeyStorePassword", "(Lp9/a;)V", "getPrivateKeyPassword", "setPrivateKeyPassword", "Ljava/io/File;", "keyStorePath", "Ljava/io/File;", "getKeyStorePath", "()Ljava/io/File;", "setKeyStorePath", "(Ljava/io/File;)V", "trustStore", "getTrustStore", "setTrustStore", "trustStorePath", "getTrustStorePath", "setTrustStorePath", "", "port", "I", "getPort", "()I", "setPort", "(I)V", "", "enabledProtocols", "Ljava/util/List;", "getEnabledProtocols", "()Ljava/util/List;", "setEnabledProtocols", "(Ljava/util/List;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EngineSSLConnectorBuilder extends EngineConnectorBuilder implements EngineSSLConnectorConfig {
    private List<String> enabledProtocols;
    private String keyAlias;
    private KeyStore keyStore;
    private InterfaceC5063a<char[]> keyStorePassword;
    private File keyStorePath;
    private int port;
    private InterfaceC5063a<char[]> privateKeyPassword;
    private KeyStore trustStore;
    private File trustStorePath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineSSLConnectorBuilder(KeyStore keyStore, String keyAlias, InterfaceC5063a<char[]> keyStorePassword, InterfaceC5063a<char[]> privateKeyPassword) {
        super(ConnectorType.INSTANCE.getHTTPS());
        kotlin.jvm.internal.p.i(keyStore, "keyStore");
        kotlin.jvm.internal.p.i(keyAlias, "keyAlias");
        kotlin.jvm.internal.p.i(keyStorePassword, "keyStorePassword");
        kotlin.jvm.internal.p.i(privateKeyPassword, "privateKeyPassword");
        this.keyStore = keyStore;
        this.keyAlias = keyAlias;
        this.keyStorePassword = keyStorePassword;
        this.privateKeyPassword = privateKeyPassword;
        this.port = 443;
    }

    @Override // io.ktor.server.engine.EngineSSLConnectorConfig
    public List<String> getEnabledProtocols() {
        return this.enabledProtocols;
    }

    @Override // io.ktor.server.engine.EngineSSLConnectorConfig
    public String getKeyAlias() {
        return this.keyAlias;
    }

    @Override // io.ktor.server.engine.EngineSSLConnectorConfig
    public KeyStore getKeyStore() {
        return this.keyStore;
    }

    @Override // io.ktor.server.engine.EngineSSLConnectorConfig
    public InterfaceC5063a<char[]> getKeyStorePassword() {
        return this.keyStorePassword;
    }

    @Override // io.ktor.server.engine.EngineSSLConnectorConfig
    public File getKeyStorePath() {
        return this.keyStorePath;
    }

    @Override // io.ktor.server.engine.EngineConnectorBuilder, io.ktor.server.engine.EngineConnectorConfig
    public int getPort() {
        return this.port;
    }

    @Override // io.ktor.server.engine.EngineSSLConnectorConfig
    public InterfaceC5063a<char[]> getPrivateKeyPassword() {
        return this.privateKeyPassword;
    }

    @Override // io.ktor.server.engine.EngineSSLConnectorConfig
    public KeyStore getTrustStore() {
        return this.trustStore;
    }

    @Override // io.ktor.server.engine.EngineSSLConnectorConfig
    public File getTrustStorePath() {
        return this.trustStorePath;
    }

    public void setEnabledProtocols(List<String> list) {
        this.enabledProtocols = list;
    }

    public void setKeyAlias(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.keyAlias = str;
    }

    public void setKeyStore(KeyStore keyStore) {
        kotlin.jvm.internal.p.i(keyStore, "<set-?>");
        this.keyStore = keyStore;
    }

    public void setKeyStorePassword(InterfaceC5063a<char[]> interfaceC5063a) {
        kotlin.jvm.internal.p.i(interfaceC5063a, "<set-?>");
        this.keyStorePassword = interfaceC5063a;
    }

    public void setKeyStorePath(File file) {
        this.keyStorePath = file;
    }

    @Override // io.ktor.server.engine.EngineConnectorBuilder
    public void setPort(int i10) {
        this.port = i10;
    }

    public void setPrivateKeyPassword(InterfaceC5063a<char[]> interfaceC5063a) {
        kotlin.jvm.internal.p.i(interfaceC5063a, "<set-?>");
        this.privateKeyPassword = interfaceC5063a;
    }

    public void setTrustStore(KeyStore keyStore) {
        this.trustStore = keyStore;
    }

    public void setTrustStorePath(File file) {
        this.trustStorePath = file;
    }
}
