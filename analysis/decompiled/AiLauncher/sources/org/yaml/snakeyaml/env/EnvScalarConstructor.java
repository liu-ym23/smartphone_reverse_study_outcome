package org.yaml.snakeyaml.env;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.sse.ServerSentEventKt;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.constructor.AbstractConstruct;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.MissingEnvironmentVariableException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes5.dex */
public class EnvScalarConstructor extends Constructor {
    public static final Tag ENV_TAG = new Tag("!ENV");
    public static final Pattern ENV_FORMAT = Pattern.compile("^\\$\\{\\s*((?<name>\\w+)((?<separator>:?(-|\\?))(?<value>\\S+)?)?)\\s*\\}$");

    public class ConstructEnv extends AbstractConstruct {
        private ConstructEnv() {
        }

        @Override // org.yaml.snakeyaml.constructor.Construct
        public Object construct(Node node) {
            Matcher matcher = EnvScalarConstructor.ENV_FORMAT.matcher(EnvScalarConstructor.this.constructScalar((ScalarNode) node));
            matcher.matches();
            String strGroup = matcher.group("name");
            String strGroup2 = matcher.group(UxipConstants.f30680s);
            String strGroup3 = matcher.group("separator");
            EnvScalarConstructor envScalarConstructor = EnvScalarConstructor.this;
            if (strGroup2 == null) {
                strGroup2 = "";
            }
            return envScalarConstructor.apply(strGroup, strGroup3, strGroup2, envScalarConstructor.getEnv(strGroup));
        }
    }

    public EnvScalarConstructor() {
        super(new LoaderOptions());
        this.yamlConstructors.put(ENV_TAG, new ConstructEnv());
    }

    public String apply(String str, String str2, String str3, String str4) {
        if (str4 != null && !str4.isEmpty()) {
            return str4;
        }
        if (str2 == null) {
            return "";
        }
        if (str2.equals("?") && str4 == null) {
            throw new MissingEnvironmentVariableException("Missing mandatory variable " + str + ": " + str3);
        }
        if (str2.equals(":?")) {
            if (str4 == null) {
                throw new MissingEnvironmentVariableException("Missing mandatory variable " + str + ": " + str3);
            }
            if (str4.isEmpty()) {
                throw new MissingEnvironmentVariableException("Empty mandatory variable " + str + ": " + str3);
            }
        }
        if (str2.startsWith(ServerSentEventKt.COLON)) {
            if (str4 != null && !str4.isEmpty()) {
                return "";
            }
        } else if (str4 != null) {
            return "";
        }
        return str3;
    }

    public String getEnv(String str) {
        return System.getenv(str);
    }

    public EnvScalarConstructor(TypeDescription typeDescription, Collection<TypeDescription> collection, LoaderOptions loaderOptions) {
        super(typeDescription, collection, loaderOptions);
        this.yamlConstructors.put(ENV_TAG, new ConstructEnv());
    }
}
