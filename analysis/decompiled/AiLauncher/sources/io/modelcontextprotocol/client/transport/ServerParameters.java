package io.modelcontextprotocol.client.transport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.modelcontextprotocol.util.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
/* loaded from: classes4.dex */
public class ServerParameters {
    private static final List<String> DEFAULT_INHERITED_ENV_VARS;

    @JsonProperty("args")
    private List<String> args;

    @JsonProperty("command")
    private String command;

    @JsonProperty("env")
    private Map<String, String> env;

    static {
        DEFAULT_INHERITED_ENV_VARS = System.getProperty("os.name").toLowerCase().contains("win") ? Arrays.asList("APPDATA", "HOMEDRIVE", "HOMEPATH", "LOCALAPPDATA", "PATH", "PROCESSOR_ARCHITECTURE", "SYSTEMDRIVE", "SYSTEMROOT", "TEMP", "USERNAME", "USERPROFILE") : Arrays.asList("HOME", "LOGNAME", "PATH", "SHELL", "TERM", "USER");
    }

    public static /* synthetic */ boolean a(Map.Entry entry) {
        return entry.getValue() != null;
    }

    public static Builder builder(String str) {
        return new Builder(str);
    }

    public static /* synthetic */ boolean c(Map.Entry entry) {
        return !((String) entry.getValue()).startsWith("()");
    }

    private static Map<String, String> getDefaultEnvironment() {
        return (Map) System.getenv().entrySet().stream().filter(new Predicate() { // from class: io.modelcontextprotocol.client.transport.n0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ServerParameters.DEFAULT_INHERITED_ENV_VARS.contains(((Map.Entry) obj).getKey());
            }
        }).filter(new Predicate() { // from class: io.modelcontextprotocol.client.transport.o0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ServerParameters.a((Map.Entry) obj);
            }
        }).filter(new Predicate() { // from class: io.modelcontextprotocol.client.transport.p0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ServerParameters.c((Map.Entry) obj);
            }
        }).collect(Collectors.toMap(new Function() { // from class: io.modelcontextprotocol.client.transport.q0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getKey();
            }
        }, new Function() { // from class: io.modelcontextprotocol.client.transport.r0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getValue();
            }
        }));
    }

    public List<String> getArgs() {
        return this.args;
    }

    public String getCommand() {
        return this.command;
    }

    public Map<String, String> getEnv() {
        return this.env;
    }

    public static class Builder {
        private String command;
        private List<String> args = new ArrayList();
        private Map<String, String> env = new HashMap();

        public Builder(String str) {
            Assert.notNull(str, "The command can not be null");
            this.command = str;
        }

        public Builder addEnvVar(String str, String str2) {
            Assert.notNull(str, "The key can not be null");
            Assert.notNull(str2, "The value can not be null");
            this.env.put(str, str2);
            return this;
        }

        public Builder arg(String str) {
            Assert.notNull(str, "The arg can not be null");
            this.args.add(str);
            return this;
        }

        public Builder args(String... strArr) {
            Assert.notNull(strArr, "The args can not be null");
            this.args = Arrays.asList(strArr);
            return this;
        }

        public ServerParameters build() {
            return new ServerParameters(this.command, this.args, this.env);
        }

        public Builder env(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                this.env.putAll(map);
            }
            return this;
        }

        public Builder args(List<String> list) {
            Assert.notNull(list, "The args can not be null");
            this.args = new ArrayList(list);
            return this;
        }
    }

    private ServerParameters(String str, List<String> list, Map<String, String> map) {
        this.args = new ArrayList();
        Assert.notNull(str, "The command can not be null");
        Assert.notNull(list, "The args can not be null");
        this.command = str;
        this.args = list;
        this.env = new HashMap(getDefaultEnvironment());
        if (map == null || map.isEmpty()) {
            return;
        }
        this.env.putAll(map);
    }
}
