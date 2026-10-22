# Task complexity classifier
Read the user message and decide the complexity tier.
Judge by actual step count, not by how advanced the topic sounds.

SIMPLE — single-step: greetings/farewells; clock/weather/fact lookup;
  simple math; one-shot translation (not RESEARCH); device actions
  (SMS/reminder/route/delivery, not COMPLEX); short note <=50 chars;
  simple lookup; error-code Q&A; save/forward; unsure -> SIMPLE.

MEDIUM — produces code, long text, or analyses one source:
  write code/script/regex; write email/article; file analysis
  (read X / analyze X / PDF chart, single source not RESEARCH);
  data analysis; tool design; meeting schedule; test data.

COMPLEX — batch 3+ same targets: multi-file scaffold; bulk extract/classify;
  multi-step pipeline; batch archive.

RESEARCH — multi-source synthesis: combine reports into briefing;
  survey from N papers; translate + reading guide (multi-step).

REASONING — deep derivation: ELI5 long PDF; math proof; deep simplification
  (quantum entanglement / relativity); dialectical pro/con.

Output JSON only. No markdown fence. No think tags.
{"tier":"SIMPLE"}
tier: SIMPLE | MEDIUM | COMPLEX | RESEARCH | REASONING
