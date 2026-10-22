package ch.qos.logback.core.joran;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.event.SaxEventRecorder;
import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.Interpreter;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.joran.spi.RuleStore;
import ch.qos.logback.core.joran.spi.SimpleRuleStore;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.StatusUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public abstract class GenericConfigurator extends ContextAwareBase {
    protected Interpreter interpreter;

    public static void informContextOfURLUsedForConfiguration(Context context, URL url) {
        ConfigurationWatchListUtil.setMainWatchURL(context, url);
    }

    public void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry defaultNestedComponentRegistry) {
    }

    public abstract void addImplicitRules(Interpreter interpreter);

    public abstract void addInstanceRules(RuleStore ruleStore);

    public void buildInterpreter() {
        SimpleRuleStore simpleRuleStore = new SimpleRuleStore(this.context);
        addInstanceRules(simpleRuleStore);
        Interpreter interpreter = new Interpreter(this.context, simpleRuleStore, initialElementPath());
        this.interpreter = interpreter;
        InterpretationContext interpretationContext = interpreter.getInterpretationContext();
        interpretationContext.setContext(this.context);
        addImplicitRules(this.interpreter);
        addDefaultNestedComponentRegistryRules(interpretationContext.getDefaultNestedComponentRegistry());
    }

    public final void doConfigure(URL url) throws JoranException, IOException {
        InputStream inputStream = null;
        try {
            try {
                informContextOfURLUsedForConfiguration(getContext(), url);
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setUseCaches(false);
                inputStream = uRLConnectionOpenConnection.getInputStream();
                doConfigure(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        addError("Could not close input stream", e4);
                        throw new JoranException("Could not close input stream", e4);
                    }
                }
            } catch (IOException e5) {
                String str = "Could not open URL [" + url + "].";
                addError(str, e5);
                throw new JoranException(str, e5);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    addError("Could not close input stream", e6);
                    throw new JoranException("Could not close input stream", e6);
                }
            }
            throw th;
        }
    }

    public ElementPath initialElementPath() {
        return new ElementPath();
    }

    public List<SaxEvent> recallSafeConfiguration() {
        return (List) this.context.getObject(CoreConstants.SAFE_JORAN_CONFIGURATION);
    }

    public void registerSafeConfiguration() {
        this.context.putObject(CoreConstants.SAFE_JORAN_CONFIGURATION, this.interpreter.getEventPlayer().getCopyOfPlayerEventList());
    }

    public final void doConfigure(String str) throws Throwable {
        doConfigure(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void doConfigure(java.io.File r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "Could not close ["
            java.lang.String r1 = "]."
            java.lang.String r2 = "Could not open ["
            r3 = 0
            ch.qos.logback.core.Context r4 = r7.getContext()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.net.URI r5 = r8.toURI()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.net.URL r5 = r5.toURL()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            informContextOfURLUsedForConfiguration(r4, r5)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r7.doConfigure(r4)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            r4.close()     // Catch: java.io.IOException -> L22
            return
        L22:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r8 = r8.getName()
            r3.append(r8)
            r3.append(r1)
            java.lang.String r8 = r3.toString()
            r7.addError(r8, r2)
            ch.qos.logback.core.joran.spi.JoranException r7 = new ch.qos.logback.core.joran.spi.JoranException
            r7.<init>(r8, r2)
            throw r7
        L3f:
            r2 = move-exception
            r3 = r4
            goto L66
        L42:
            r3 = move-exception
            goto L4a
        L44:
            r2 = move-exception
            goto L66
        L46:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
        L4a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = r8.getPath()     // Catch: java.lang.Throwable -> L3f
            r5.append(r2)     // Catch: java.lang.Throwable -> L3f
            r5.append(r1)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L3f
            r7.addError(r2, r3)     // Catch: java.lang.Throwable -> L3f
            ch.qos.logback.core.joran.spi.JoranException r5 = new ch.qos.logback.core.joran.spi.JoranException     // Catch: java.lang.Throwable -> L3f
            r5.<init>(r2, r3)     // Catch: java.lang.Throwable -> L3f
            throw r5     // Catch: java.lang.Throwable -> L3f
        L66:
            if (r3 == 0) goto L89
            r3.close()     // Catch: java.io.IOException -> L6c
            goto L89
        L6c:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r8 = r8.getName()
            r3.append(r8)
            r3.append(r1)
            java.lang.String r8 = r3.toString()
            r7.addError(r8, r2)
            ch.qos.logback.core.joran.spi.JoranException r7 = new ch.qos.logback.core.joran.spi.JoranException
            r7.<init>(r8, r2)
            throw r7
        L89:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.joran.GenericConfigurator.doConfigure(java.io.File):void");
    }

    public final void doConfigure(InputStream inputStream) throws SAXException, JoranException, IOException {
        doConfigure(new InputSource(inputStream));
    }

    public final void doConfigure(InputSource inputSource) throws SAXException, JoranException, IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!ConfigurationWatchListUtil.wasConfigurationWatchListReset(this.context)) {
            informContextOfURLUsedForConfiguration(getContext(), null);
        }
        SaxEventRecorder saxEventRecorder = new SaxEventRecorder(this.context);
        saxEventRecorder.recordEvents(inputSource);
        doConfigure(saxEventRecorder.saxEventList);
        if (new StatusUtil(this.context).noXMLParsingErrorsOccurred(jCurrentTimeMillis)) {
            addInfo("Registering current configuration as safe fallback point");
            registerSafeConfiguration();
        }
    }

    public void doConfigure(List<SaxEvent> list) throws JoranException {
        buildInterpreter();
        synchronized (this.context.getConfigurationLock()) {
            this.interpreter.getEventPlayer().play(list);
        }
    }
}
